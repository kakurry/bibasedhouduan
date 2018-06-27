package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.YudingMstMapper;
import com.example.bibasedhouduan.javabean.YudingMst;
import com.example.bibasedhouduan.javabean.YudingMstExample;
import com.example.bibasedhouduan.service.YudingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("yudingServiceImpl")
public class YudingServiceImple implements YudingService {
    @Autowired
    private YudingMstMapper yudingMstMapper;

    @Override
    public void batchDisabled(List<YudingMst> list) {
        for(YudingMst obj : list){
            yudingMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(YudingMst yudingMst) {
        yudingMstMapper.updateByPrimaryKey(yudingMst);
    }

    @Override
    public void insert(YudingMst yudingMst) {
        yudingMstMapper.insert(yudingMst);
    }

    @Override
    public List<YudingMst> selectByExample(YudingMstExample criteria) {
        return yudingMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(YudingMstExample criteria) {
        return yudingMstMapper.countByExample(criteria);
    }
}
