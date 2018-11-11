package com.witcher.kicker.domain.rosman.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RosmanSetting {

    @Value("${rosman.url}")
    private String url;

    @Value("${rosman.enable}")
    private boolean enable;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
