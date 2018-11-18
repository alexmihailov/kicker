package com.witcher.kicker.domain.zigzag.service;

import com.witcher.kicker.database.pager.CircularPagerService;
import com.witcher.kicker.domain.zigzag.exception.ZigzagException;
import com.witcher.kicker.domain.zigzag.setting.ZigzagSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class ZigzagServiceImpl implements ZigzagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZigzagServiceImpl.class);

    @Autowired
    private ZigzagSetting settings;

    @Autowired
    @Qualifier("zigzag_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("zigzag_header")
    private HttpHeaders headers;

    @Autowired
    private CircularPagerService pagerService;

    @Autowired
    private ZigzagRequestBuilderService requestBuilder;

    @PostConstruct
    public void setup() {
        headers.setAll(settings.getHeaders());
    }

    @Override
    public void sendZigzagRequest() throws ZigzagException {
        if (!settings.isEnable()) {
            LOGGER.info("[zigzag]: Service disable.");
            return;
        }

        try {
            String body = requestBuilder.buildRequest(pagerService.next());
            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
            LOGGER.info("[zigzag]: Request to Zigzag with entity - " + requestEntity.toString());
            ResponseEntity<String> responseEntity = restTemplate.exchange(settings.getUrl(),
                    HttpMethod.POST, requestEntity, String.class);
            LOGGER.info("[zigzag]: Response from Zigzag with entity - " + responseEntity.toString());
        } catch (Exception e) {
            throw new ZigzagException(e);
        }
    }
}
