package com.witcher.kicker.domain.zigzag.service;

import com.witcher.kicker.domain.zigzag.exception.ZigzagException;

public interface ZigzagService {

    void sendZigzagRequest() throws ZigzagException;
}
