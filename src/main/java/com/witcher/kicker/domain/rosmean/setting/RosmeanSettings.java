package com.witcher.kicker.domain.rosmean.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RosmeanSettings {

    @Value("${rosmean.url}")
    private String url;

    @Value("${rosmean.enable}")
    private boolean enable;

    @Value("#{${rosmean.headers}}")
    private Map<String, String> headers;

    @Value("${rosmean.page_id}")
    private long pageId;

    @Value("${rosmean.ab_id}")
    private long abId;

    @Value("${rosmean.refer}")
    private String refer;

    @Value("${rosmean.uri}")
    private String uri;

    public String getUrl() {
        return url;
    }

    public boolean isEnable() {
        return enable;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public long getPageId() {
        return pageId;
    }

    public long getAbId() {
        return abId;
    }

    public String getRefer() {
        return refer;
    }

    public String getUri() {
        return uri;
    }
}
