package com.witcher.kicker.domain.kupipotter.service;

import com.witcher.kicker.domain.kupipotter.exception.KupipotterException;

public interface KupipotterService {

    void sendKupipotterRequest() throws KupipotterException;
}
