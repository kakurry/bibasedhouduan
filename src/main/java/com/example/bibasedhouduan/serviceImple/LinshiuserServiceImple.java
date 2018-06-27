package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.LinshiuserMstMapper;
import com.example.bibasedhouduan.javabean.LinshiuserMst;
import com.example.bibasedhouduan.service.LinshiuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("linshiuserServiceImpl")
public class LinshiuserServiceImple implements LinshiuserService {
    @Autowired
    private LinshiuserMstMapper linshiuserMstMapper;

    @Override
    public void delete() {
        linshiuserMstMapper.delete();
    }

    @Override
    public void insert(LinshiuserMst linshiuserMst) {
        linshiuserMstMapper.insert(linshiuserMst);
    }

    @Override
    public LinshiuserMst select() {
        return linshiuserMstMapper.selectLinshi();
    }
}
