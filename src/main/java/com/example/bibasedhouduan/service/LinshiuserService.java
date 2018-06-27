package com.example.bibasedhouduan.service;

import com.example.bibasedhouduan.javabean.LinshiuserMst;

public interface LinshiuserService {
    void delete();

    void insert(LinshiuserMst linshiuserMst);

    LinshiuserMst select();
}
