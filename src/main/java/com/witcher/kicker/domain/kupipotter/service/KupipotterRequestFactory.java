package com.witcher.kicker.domain.kupipotter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.witcher.kicker.database.entity.InformationBody;

public interface KupipotterRequestFactory {

    String buildRequest(InformationBody body) throws JsonProcessingException;
}
