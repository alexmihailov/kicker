package com.witcher.kicker.domain.zigzag.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witcher.kicker.database.entity.InformationBody;
import com.witcher.kicker.domain.zigzag.entity.FieldItem;
import com.witcher.kicker.domain.zigzag.entity.Hit;
import com.witcher.kicker.domain.zigzag.entity.ZigZagRequest;
import com.witcher.kicker.domain.zigzag.setting.ZigzagSetting;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ZigZagRequestBuilderServiceImpl implements ZigZagRequestBuilderService {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_PHONE = 1;
    private static final int INDEX_EMAIL = 2;
    private static final int INDEX_CITY = 3;
    private static final int INDEX_COUNT = 4;

    private static final int MAX_COUNT = 10;
    private static final int MIN_COUNT = 1;

    @Autowired
    private ZigzagSetting setting;

    private ZigZagRequest request;
    private ObjectMapper objectMapper;

    @PostConstruct
    private void setup() {
        List<FieldItem> items = Arrays.asList(
                new FieldItem("Имя", "name", true, ""),
                new FieldItem("Телефон", "phone", true, ""),
                new FieldItem("Электронная почта", "email", true, ""),
                new FieldItem("Город", "text", true,""),
                new FieldItem("Количество", "text", true,"")
        );
        Hit hit = new Hit(setting.getPageId(), setting.getAbId(), setting.getRefer(), setting.getUri());

        request = new ZigZagRequest(hit, items);
        objectMapper = new ObjectMapper();
    }

    @Override
    public String buildRequest(InformationBody body) throws JsonProcessingException {
        request.getFields().get(INDEX_NAME).setValue(body.getName());
        request.getFields().get(INDEX_PHONE).setValue(body.getPhone());
        request.getFields().get(INDEX_EMAIL).setValue(body.getEmail());
        request.getFields().get(INDEX_CITY).setValue(body.getCity());
        request.getFields().get(INDEX_COUNT).setValue(
                new Random().nextInt(MAX_COUNT - MIN_COUNT + 1) + MIN_COUNT + ""
        );

        return objectMapper.writeValueAsString(request);
    }
}
