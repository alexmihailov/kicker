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

    @Value("${kupipotter.page_id}")
    private long pageId;

    @Value("${kupipotter.ab_id}")
    private long abId;

    @Value("${kupipotter.refer}")
    private String refer;

    @Value("${kupipotter.uri}")
    private String uri;

    @Value("${kupipotter.enable}")
    private boolean enable;

    public String getUrl() {
        return url;
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

    public boolean isEnable() {
        return enable;
    }
}
