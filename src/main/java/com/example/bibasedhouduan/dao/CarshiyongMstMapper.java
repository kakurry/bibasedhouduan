package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.CarshiyongMst;
import com.example.bibasedhouduan.javabean.CarshiyongMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarshiyongMstMapper {
    int countByExample(CarshiyongMstExample example);

    int deleteByExample(CarshiyongMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(CarshiyongMst record);

    int insertSelective(CarshiyongMst record);

    List<CarshiyongMst> selectByExample(CarshiyongMstExample example);

    CarshiyongMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CarshiyongMst record, @Param("example") CarshiyongMstExample example);

    int updateByExample(@Param("record") CarshiyongMst record, @Param("example") CarshiyongMstExample example);

    int updateByPrimaryKeySelective(CarshiyongMst record);

    int updateByPrimaryKey(CarshiyongMst record);
}