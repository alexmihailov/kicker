package com.witcher.kicker.domain.rosman.service;

import com.witcher.kicker.database.pager.CircularPagerService;
import com.witcher.kicker.domain.rosman.exception.RosmanException;
import com.witcher.kicker.domain.rosman.setting.RosmanSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RosmanServiceImpl implements RosmanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RosmanServiceImpl.class);

    @Autowired
    private RosmanSetting settings;

    @Autowired
    @Qualifier("rosman_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("rosman_headers")
    private HttpHeaders headers;

    @Autowired
    private CircularPagerService pagerService;

    @Autowired
    private RosmanRequestBuilderService requestBuilder;

    @Override
    public void sendRosmanRequest() throws RosmanException {
        if (!settings.isEnable()) {
            LOGGER.info("[rosman]: Service disable.");
            return;
        }

        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.setAll(requestBuilder.buildRequestFormData(pagerService.next()));
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(multiValueMap, headers);
            LOGGER.info("[rosman]: Request to Rosman with entity - " + requestEntity.toString());
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(settings.getUrl(), requestEntity , String.class);
            LOGGER.info("[rosman]: Response from Rosman with entity - " + responseEntity.toString());
        } catch (Exception e) {
            throw new RosmanException(e);
        }
    }
}
