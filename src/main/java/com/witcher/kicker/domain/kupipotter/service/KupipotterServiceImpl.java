package com.witcher.kicker.domain.kupipotter.service;

import com.witcher.kicker.database.pager.CircularPagerService;
import com.witcher.kicker.domain.kupipotter.setting.KupipotterSettings;
import com.witcher.kicker.domain.kupipotter.exception.KupipotterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class KupipotterServiceImpl implements KupipotterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KupipotterServiceImpl.class);

    @Autowired
    private KupipotterSettings settings;

    @Autowired
    @Qualifier("kupipotter_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("kupipotter_header")
    private HttpHeaders headers;

    @Autowired
    private KupipotterRequestBuilderService requestBuilder;

    @Autowired
    private CircularPagerService pagerService;

    @PostConstruct
    public void setup() {
        headers.setAll(settings.getHeaders());
    }

    @Override
    public void sendKupipotterRequest() throws KupipotterException {
        if (!settings.isEnable()) {
            LOGGER.info("[kupipotter]: Service disable.");
            return;
        }

        try {
            String body = requestBuilder.buildRequest(pagerService.next());
            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
            LOGGER.info("[kupipotter]: Request to Kupipotter with entity - " + requestEntity.toString());
            ResponseEntity<String> responseEntity = restTemplate.exchange(settings.getUrl(),
                    HttpMethod.POST, requestEntity, String.class);
            LOGGER.info("[kupipotter]: Response from Kupipotter with entity - " + responseEntity.toString());
        } catch (Exception ex) {
            throw new KupipotterException(ex);
        }
    }
}
