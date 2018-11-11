package com.witcher.kicker.domain.zigzag.service;

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

    private static final Logger logger = LoggerFactory.getLogger(ZigzagServiceImpl.class);

    @Autowired
    private ZigzagSetting settings;

    @Autowired
    @Qualifier("zigzag_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("zigzag_header")
    private HttpHeaders headers;

    @PostConstruct
    public void setup() {
        headers.setAll(settings.getHeaders());
    }

    @Override
    public void sendZigzagRequest() throws ZigzagException {
        String body = "temp"; // TODO add repository
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        logger.debug("[zigzag]: Request to Zigzag with entity - " + requestEntity.toString());
        ResponseEntity<String> responseEntity = restTemplate.exchange(settings.getUrl(),
                HttpMethod.POST, requestEntity, String.class);
        logger.debug("[zigzag]: Response from Zigzag with entity - " + responseEntity.toString());
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new ZigzagException(responseEntity.getBody());
        }
    }
}
