package com.witcher.kicker.domain.rosmean.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.witcher.kicker.database.entity.InformationBody;

public interface RosmeanRequestBuilderService {

    String buildRequest(InformationBody body) throws JsonProcessingException;
}
