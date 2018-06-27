package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.KuneicarMst;
import com.example.bibasedhouduan.javabean.KuneicarMstExample;

import java.util.List;

public interface KuneicarService {
    void batchDisabled(List<KuneicarMst> list);

    void update(KuneicarMst kuneicarMst);

    void insert(KuneicarMst kuneicarMst);

    int countByCriteria(KuneicarMstExample criteria);

    List<KuneicarMst> selectByExample(KuneicarMstExample criteria);
}
