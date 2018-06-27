package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.GuanliyuanuserMst;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMstExample;

import java.util.List;

public interface GuanliyuanService {
    List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample criteria);

    int countByCriteria(GuanliyuanuserMstExample criteria);

    int yanchongByname(GuanliyuanuserMstExample criteria);

    void insert(GuanliyuanuserMst gly);

    void update(GuanliyuanuserMst gly);

    void batchDisabled(List<GuanliyuanuserMst> list);

    int selectBynameAndpassword(GuanliyuanuserMstExample criteria);
}
