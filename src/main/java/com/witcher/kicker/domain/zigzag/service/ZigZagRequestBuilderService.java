package com.witcher.kicker.domain.zigzag.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.witcher.kicker.database.entity.InformationBody;

public interface ZigZagRequestBuilderService {

    String buildRequest(InformationBody body) throws JsonProcessingException;
}
