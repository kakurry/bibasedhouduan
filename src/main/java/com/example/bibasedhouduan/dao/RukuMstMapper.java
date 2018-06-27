package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.RukuMst;
import com.example.bibasedhouduan.javabean.RukuMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RukuMstMapper {
    int countByExample(RukuMstExample example);

    int deleteByExample(RukuMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(RukuMst record);

    int insertSelective(RukuMst record);

    List<RukuMst> selectByExample(RukuMstExample example);

    RukuMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RukuMst record, @Param("example") RukuMstExample example);

    int updateByExample(@Param("record") RukuMst record, @Param("example") RukuMstExample example);

    int updateByPrimaryKeySelective(RukuMst record);

    int updateByPrimaryKey(RukuMst record);
}