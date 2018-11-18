package com.witcher.kicker.domain.kupipotter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.witcher.kicker.database.entity.InformationBody;

public interface KupipotterRequestBuilderService {

    String buildRequest(InformationBody body) throws JsonProcessingException;
}
