package com.example.bibasedhouduan.serviceImple;

import com.example.bibasedhouduan.dao.CarshiyongMstMapper;
import com.example.bibasedhouduan.javabean.CarshiyongMst;
import com.example.bibasedhouduan.javabean.CarshiyongMstExample;
import com.example.bibasedhouduan.service.CarshiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carshiyongServiceImpl")
public class CarshiyongServiceImple implements CarshiyongService {
    @Autowired
    private CarshiyongMstMapper carshiyongMstMapper;

    @Override
    public List<CarshiyongMst> selectByExample(CarshiyongMstExample criteria) {
        return carshiyongMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(CarshiyongMstExample criteria) {
        return carshiyongMstMapper.countByExample(criteria);
    }
}
