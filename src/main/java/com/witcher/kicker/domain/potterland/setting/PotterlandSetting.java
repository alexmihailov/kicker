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

    @Value("${potterland.enable}")
    private boolean enable;

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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
