package com.witcher.kicker.database.pager;

import com.witcher.kicker.database.entity.InformationBody;
import com.witcher.kicker.database.exception.PagerException;
import com.witcher.kicker.database.repository.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CircularPagerServiceImpl implements CircularPagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircularPagerServiceImpl.class);

    private static final int BATCH_SIZE = 10;

    private List<InformationBody> cache;
    private PageRequest pageRequest;

    @Autowired
    private InformationRepository repository;

    @PostConstruct
    private void setup() {
        cache = new ArrayList<>();
        pageRequest = createInitialPageRequest();
    }

    @Override
    public synchronized InformationBody next() throws PagerException {
        if (!cache.isEmpty()) {
            LOGGER.debug("[pager] Get row from cache.");
            return getFromCache();
        } else {
            LOGGER.debug("[pager] Get row from DB.");
            Page<InformationBody> page = repository.findAll(pageRequest);
            if (!page.hasContent()) {
                throw new PagerException("No rows in database!");
            }
            cache = new ArrayList<>(page.getContent());

            if (page.hasNext()) {
                LOGGER.debug("[pager] Go to next page.");
                pageRequest = (PageRequest) page.nextPageable();
            } else {
                LOGGER.debug("[pager] Return to initial page.");
                pageRequest = createInitialPageRequest();
            }

            return getFromCache();
        }
    }

    private PageRequest createInitialPageRequest(){
        return PageRequest.of(0, BATCH_SIZE);
    }

    private InformationBody getFromCache() {
        InformationBody result = cache.get(0);
        cache.remove(0);
        return result;
    }
}
