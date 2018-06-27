package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.YudingMst;
import com.example.bibasedhouduan.javabean.YudingMstExample;

import java.util.List;

public interface YudingService {
    void batchDisabled(List<YudingMst> list);

    void update(YudingMst yudingMst);

    void insert(YudingMst yudingMst);

    List<YudingMst> selectByExample(YudingMstExample criteria);

    int countByCriteria(YudingMstExample criteria);
}
