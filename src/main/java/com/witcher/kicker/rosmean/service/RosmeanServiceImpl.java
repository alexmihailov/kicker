package com.witcher.kicker.rosmean.service;

import com.witcher.kicker.rosmean.exception.RosmeanException;
import com.witcher.kicker.rosmean.setting.RosmeanSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class RosmeanServiceImpl implements RosmeanService {

    private static final Logger logger = LoggerFactory.getLogger(RosmeanServiceImpl.class);

    @Autowired
    private RosmeanSettings settings;

    @Autowired
    @Qualifier("rosmean_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("rosmean_header")
    private HttpHeaders headers;

    @PostConstruct
    public void setup() {
        headers.setAll(settings.getHeaders());
    }


    @Override
    public void sendRosmeanRequest() throws RosmeanException {
        String body = ""; // TODO add repository
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        logger.debug("[rosmean]: Request to Rosmean with entity - " + requestEntity.toString());
        ResponseEntity<String> responseEntity = restTemplate.exchange(settings.getUrl(),
                HttpMethod.POST, requestEntity, String.class);
        logger.debug("[rosmean]: Response from Rosmean with entity - " + responseEntity.toString());
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RosmeanException(responseEntity.getBody());
        }
    }
}
