package com.witcher.kicker.domain.rosmean.service;

import com.witcher.kicker.domain.rosmean.exception.RosmeanException;

public interface RosmeanService {

    void sendRosmeanRequest() throws RosmeanException;
}
