package com.witcher.kicker.domain.zigzag.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ZigzagSetting {

    @Value("${zigzag.url}")
    private String url;

    @Value("#{${zigzag.headers}}")
    private Map<String, String> headers;

    @Value("${zigzag.page_id}")
    private long pageId;

    @Value("${zigzag.ab_id}")
    private long abId;

    @Value("${zigzag.refer}")
    private String refer;

    @Value("${zigzag.uri}")
    private String uri;

    @Value("${zigzag.enable}")
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
