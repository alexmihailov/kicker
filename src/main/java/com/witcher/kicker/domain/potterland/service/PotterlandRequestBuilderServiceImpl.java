package com.witcher.kicker.domain.potterland.service;

import com.witcher.kicker.database.entity.InformationBody;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PotterlandRequestBuilderServiceImpl implements PotterlandRequestBuilderService {

    private static final String KEY_NAME = "form[14693]";
    private static final String KEY_PHONE = "form[10002]";

    @Override
    public Map<String, String> buildRequestFromData(InformationBody body) {
        Map<String, String> formData = new HashMap<>();
        formData.put("p_id", "428202");
        formData.put("id", "119");
        formData.put("name", "Заявка");
        formData.put("type[14693]", "name");
        formData.put("vars[14693]", "Имя");
        formData.put("type[10002]", "phone");
        formData.put("vars[10002]", "Телефон");
        formData.put("f_uid", "160110939");
        formData.put("jsform", "448312");
        formData.put("is_ajax", "true");

        formData.put(KEY_NAME, body.getName());
        formData.put(KEY_PHONE, body.getPhone());

        return formData;
    }
}
