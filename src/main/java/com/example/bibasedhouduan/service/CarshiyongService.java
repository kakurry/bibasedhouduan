package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.CarshiyongMst;
import com.example.bibasedhouduan.javabean.CarshiyongMstExample;

import java.util.List;

public interface CarshiyongService {
    List<CarshiyongMst> selectByExample(CarshiyongMstExample criteria);

    int countByCriteria(CarshiyongMstExample criteria);
}
