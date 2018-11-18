package com.witcher.kicker.domain.rosman.service;

import com.witcher.kicker.database.entity.InformationBody;

import java.util.Map;

public interface RosmanRequestBuilderService {

    Map<String, String> buildRequestFormData(InformationBody body);
}
