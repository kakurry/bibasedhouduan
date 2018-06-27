package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.KuneicarMstMapper;
import com.example.bibasedhouduan.javabean.KuneicarMst;
import com.example.bibasedhouduan.javabean.KuneicarMstExample;
import com.example.bibasedhouduan.service.KuneicarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("kuneicarServiceImpl")
public class KuneicarServiceImple implements KuneicarService {
    @Autowired
    private KuneicarMstMapper kuneicarMstMapper;

    @Override
    public void batchDisabled(List<KuneicarMst> list) {
        for(KuneicarMst obj : list){
            kuneicarMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(KuneicarMst kuneicarMst) {
        kuneicarMstMapper.updateByPrimaryKey(kuneicarMst);
    }

    @Override
    public void insert(KuneicarMst kuneicarMst) {
        kuneicarMstMapper.insert(kuneicarMst);
    }

    @Override
    public int countByCriteria(KuneicarMstExample criteria) {
        return kuneicarMstMapper.countByExample(criteria);
    }

    @Override
    public List<KuneicarMst> selectByExample(KuneicarMstExample criteria) {
        return kuneicarMstMapper.selectByExample(criteria);
    }
}
