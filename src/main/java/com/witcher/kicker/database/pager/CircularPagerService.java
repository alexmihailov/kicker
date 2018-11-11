package com.witcher.kicker.database.pager;

import com.witcher.kicker.database.entity.InformationBody;
import com.witcher.kicker.database.exception.PagerException;

public interface CircularPagerService {

    InformationBody next() throws PagerException;
}
