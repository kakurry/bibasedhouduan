package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.YudingMst;
import com.example.bibasedhouduan.javabean.YudingMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface YudingMstMapper {
    int countByExample(YudingMstExample example);

    int deleteByExample(YudingMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(YudingMst record);

    int insertSelective(YudingMst record);

    List<YudingMst> selectByExample(YudingMstExample example);

    YudingMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YudingMst record, @Param("example") YudingMstExample example);

    int updateByExample(@Param("record") YudingMst record, @Param("example") YudingMstExample example);

    int updateByPrimaryKeySelective(YudingMst record);

    int updateByPrimaryKey(YudingMst record);
}