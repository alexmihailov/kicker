package com.witcher.kicker.domain.kupipotter.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KupipotterSettings {

    @Value("${kupipotter.url}")
    private String url;

    @Value("#{${kupipotter.headers}}")
    private Map<String, String> headers;

    @Value("${kupipotter.enable}")
    private boolean enable;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
