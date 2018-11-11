package com.witcher.kicker.domain.rosman.service;

import com.witcher.kicker.domain.rosman.exception.RosmanException;

public interface RosmanService {

    void sendRosmanRequest() throws RosmanException;
}
