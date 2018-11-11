package com.witcher.kicker.kupipotter.service;

import com.witcher.kicker.kupipotter.setting.KupipotterSettings;
import com.witcher.kicker.kupipotter.exception.KupipotterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class KupipotterServiceImpl implements KupipotterService {

    private static final Logger logger = LoggerFactory.getLogger(KupipotterServiceImpl.class);

    @Autowired
    private KupipotterSettings settings;

    @Autowired
    @Qualifier("kupipotter_rest_template")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("kupipotter_header")
    private HttpHeaders headers;

    @PostConstruct
    public void setup() {
        headers.setAll(settings.getHeaders());
    }

    @Override
    public void sendKupipotterRequest() throws KupipotterException {
        String body = ""; // TODO add repository
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        logger.debug("[kupipotter]: Request to Kupipotter with entity - " + requestEntity.toString());
        ResponseEntity<String> responseEntity = restTemplate.exchange(settings.getUrl(),
                HttpMethod.POST, requestEntity, String.class);
        logger.debug("[kupipotter]: Response from Kupipotter with entity - " + responseEntity.toString());
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new KupipotterException(responseEntity.getBody());
        }
    }
}
