package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.UserMst;
import com.example.bibasedhouduan.javabean.UserMstExample;

import java.util.List;

public interface UserService {
    List<UserMst> selectByExample(UserMstExample criteria);

    int countByCriteria(UserMstExample criteria);

    void insert(UserMst userMst);

    void update(UserMst userMst);

    void batchDisabled(List<UserMst> list);
}
