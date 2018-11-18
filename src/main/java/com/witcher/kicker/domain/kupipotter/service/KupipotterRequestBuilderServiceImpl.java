package com.witcher.kicker.domain.kupipotter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witcher.kicker.database.entity.InformationBody;
import com.witcher.kicker.domain.kupipotter.entity.FieldItem;
import com.witcher.kicker.domain.kupipotter.entity.Hit;
import com.witcher.kicker.domain.kupipotter.entity.KupipotterRequest;
import com.witcher.kicker.domain.kupipotter.setting.KupipotterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class KupipotterRequestBuilderServiceImpl implements KupipotterRequestBuilderService {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_PHONE = 1;
    private static final int INDEX_METHOD = 2;
    private static final int INDEX_ADDRESS = 3;

    @Autowired
    private KupipotterSettings settings;

    private KupipotterRequest request;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void setup() {
        List<FieldItem> items = Arrays.asList(
                new FieldItem("ФИО", "name", true, ""),
                new FieldItem("Номер телефона", "phone", true, ""),
                new FieldItem("Выберете способ доставки:", "radio-list", true,""),
                new FieldItem("Адрес доставки, время и информация для курьера", "text", true,"")
        );
        Hit hit = new Hit(settings.getPageId(), settings.getAbId(), settings.getRefer(), settings.getUri());

        request = new KupipotterRequest(hit, items);
        objectMapper = new ObjectMapper();
    }

    @Override
    public String buildRequest(InformationBody body) throws JsonProcessingException {
        request.getFields().get(INDEX_NAME).setValue(body.getName());
        request.getFields().get(INDEX_PHONE).setValue(body.getPhone());
        request.getFields().get(INDEX_METHOD).setValue(body.getDeliveryMethod());
        request.getFields().get(INDEX_ADDRESS).setValue(body.getDeliveryAddress());

        return objectMapper.writeValueAsString(request);
    }
}
