package com.witcher.kicker.domain.rosmean.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witcher.kicker.database.entity.InformationBody;
import com.witcher.kicker.domain.rosmean.entity.FieldItem;
import com.witcher.kicker.domain.rosmean.entity.Hit;
import com.witcher.kicker.domain.rosmean.entity.RosmeanRequest;
import com.witcher.kicker.domain.rosmean.setting.RosmeanSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class RosmeanRequestBuilderServiceImpl implements RosmeanRequestBuilderService {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_PHONE = 1;

    @Autowired
    private RosmeanSettings settings;

    private RosmeanRequest request;
    private ObjectMapper objectMapper;

    @PostConstruct
    private void setup() {
        List<FieldItem> items = Arrays.asList(
                new FieldItem("Имя", "name", false, ""),
                new FieldItem("Телефон", "phone", true, "")
        );
        Hit hit = new Hit(settings.getPageId(), settings.getAbId(), settings.getRefer(), settings.getUri());

        request = new RosmeanRequest(hit, items);
        objectMapper = new ObjectMapper();
    }

    @Override
    public String buildRequest(InformationBody body) throws JsonProcessingException {
        request.getFields().get(INDEX_NAME).setValue(body.getName());
        request.getFields().get(INDEX_PHONE).setValue(body.getPhone());

        return objectMapper.writeValueAsString(request);
    }
}
