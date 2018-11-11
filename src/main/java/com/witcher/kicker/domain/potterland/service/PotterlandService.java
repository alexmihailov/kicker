package com.witcher.kicker.domain.potterland.service;

import com.witcher.kicker.domain.potterland.exception.PotterlandException;

public interface PotterlandService {

    void sendPotterlandRequest() throws PotterlandException;
}
