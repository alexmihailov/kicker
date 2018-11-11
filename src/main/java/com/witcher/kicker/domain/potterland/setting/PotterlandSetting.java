package com.witcher.kicker.domain.potterland.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PotterlandSetting {

    @Value("${potterland.url}")
    private String url;

    @Value("#{${potterland.body}}")
    private Map<String, String> bodyFormData;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getBodyFormData() {
        return bodyFormData;
    }

    public void setBodyFormData(Map<String, String> bodyFormData) {
        this.bodyFormData = bodyFormData;
    }
}
