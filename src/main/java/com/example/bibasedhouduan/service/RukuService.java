package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.RukuMst;
import com.example.bibasedhouduan.javabean.RukuMstExample;

import java.util.List;

public interface RukuService {
    void batchDisabled(List<RukuMst> list);
    

    List<RukuMst> selectByExample(RukuMstExample criteria);

    int countByCriteria(RukuMstExample criteria);

    void insert(RukuMst rukuMst);

    void update(RukuMst rukuMst);
}
