package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.RukuMstMapper;
import com.example.bibasedhouduan.javabean.RukuMst;
import com.example.bibasedhouduan.javabean.RukuMstExample;
import com.example.bibasedhouduan.service.RukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rukuServiceImpl")
public class RukeServiceImple implements RukuService {
    @Autowired
    private RukuMstMapper rukuMstMapper;

    @Override
    public void batchDisabled(List<RukuMst> list) {
        for(RukuMst obj : list){
            rukuMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }


    @Override
    public List<RukuMst> selectByExample(RukuMstExample criteria) {
        return rukuMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(RukuMstExample criteria) {
        return rukuMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(RukuMst rukuMst) {
        rukuMstMapper.insert(rukuMst);
    }

    @Override
    public void update(RukuMst rukuMst) {
        rukuMstMapper.updateByPrimaryKey(rukuMst);
    }
}
