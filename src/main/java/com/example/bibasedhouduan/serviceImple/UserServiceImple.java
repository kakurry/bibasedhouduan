package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.UserMstMapper;
import com.example.bibasedhouduan.javabean.UserMst;
import com.example.bibasedhouduan.javabean.UserMstExample;
import com.example.bibasedhouduan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImple implements UserService {
    @Autowired
    private UserMstMapper userMstMapper;

    @Override
    public List<UserMst> selectByExample(UserMstExample criteria) {
        return userMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(UserMstExample criteria) {
        return userMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(UserMst userMst) {
        userMstMapper.insert(userMst);
    }

    @Override
    public void update(UserMst userMst) {
        userMstMapper.updateByPrimaryKey(userMst);
    }

    @Override
    public void batchDisabled(List<UserMst> list) {
        for(UserMst obj : list){
            userMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }
}
