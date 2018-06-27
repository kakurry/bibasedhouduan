package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.GuanliyuanuserMst;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuanliyuanuserMstMapper {
    int countByExample(GuanliyuanuserMstExample example);

    int deleteByExample(GuanliyuanuserMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(GuanliyuanuserMst record);

    int insertSelective(GuanliyuanuserMst record);

    List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample example);

    GuanliyuanuserMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GuanliyuanuserMst record, @Param("example") GuanliyuanuserMstExample example);

    int updateByExample(@Param("record") GuanliyuanuserMst record, @Param("example") GuanliyuanuserMstExample example);

    int updateByPrimaryKeySelective(GuanliyuanuserMst record);

    int updateByPrimaryKey(GuanliyuanuserMst record);
}