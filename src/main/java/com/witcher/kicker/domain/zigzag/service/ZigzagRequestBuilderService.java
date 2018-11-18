package com.witcher.kicker.domain.zigzag.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.witcher.kicker.database.entity.InformationBody;

public interface ZigzagRequestBuilderService {

    String buildRequest(InformationBody body) throws JsonProcessingException;
}
