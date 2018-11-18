package com.witcher.kicker.domain.potterland.service;

import com.witcher.kicker.database.entity.InformationBody;

import java.util.Map;

public interface PotterlandRequestBuilderService {

    Map<String, String> buildRequestFromData(InformationBody body);
}
