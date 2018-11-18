package com.witcher.kicker.domain.rosman.service;

import com.witcher.kicker.database.entity.InformationBody;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RosmanRequestBuilderServiceImpl implements RosmanRequestBuilderService {

    private static final String KEY_NAME = "input_2907";
    private static final String KEY_PHONE = "input_1253";

    @Override
    public Map<String, String> buildRequestFormData(InformationBody body) {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_NAME, body.getName());
        map.put(KEY_PHONE, body.getPhone());
        return map;
    }
}
