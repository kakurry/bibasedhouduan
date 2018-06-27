package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.GuanliyuanuserMstMapper;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMst;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMstExample;
import com.example.bibasedhouduan.service.GuanliyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("guanliyuanServiceImpl")
public class GuanliyuanServiceImple implements GuanliyuanService {
    @Autowired
    private GuanliyuanuserMstMapper guanliyuanuserMstMapper;

    @Override
    public List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }

    @Override
    public int yanchongByname(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(GuanliyuanuserMst gly) {
        guanliyuanuserMstMapper.insert(gly);
    }

    @Override
    public void update(GuanliyuanuserMst gly) {
        guanliyuanuserMstMapper.updateByPrimaryKey(gly);
    }

    @Override
    public void batchDisabled(List<GuanliyuanuserMst> list) {
        for(GuanliyuanuserMst obj : list){
            guanliyuanuserMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public int selectBynameAndpassword(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }
}
