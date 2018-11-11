package com.witcher.kicker.domain.potterland.service;

import com.witcher.kicker.domain.potterland.exception.PotterlandException;
import com.witcher.kicker.domain.potterland.setting.PotterlandSetting;
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
public class PotterlandServiceImpl implements PotterlandService {

    private static final Logger logger = LoggerFactory.getLogger(PotterlandServiceImpl.class);

    @Autowired
    private PotterlandSetting setting;

    @Autowired
    @Qualifier("potterland_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("potterland_headers")
    private HttpHeaders headers;

    @Override
    public void sendPotterlandRequest() throws PotterlandException {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.setAll(setting.getBodyFormData());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(multiValueMap, headers);
        logger.debug("[potterland]: Request to Potterland with entity - " + requestEntity.toString());
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(setting.getUrl(), requestEntity , String.class);
        logger.debug("[potterland]: Response from Potterland with entity - " + responseEntity.toString());
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new PotterlandException(responseEntity.getBody());
        }
    }
}
