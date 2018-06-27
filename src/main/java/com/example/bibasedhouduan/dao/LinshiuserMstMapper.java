package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.LinshiuserMst;
import com.example.bibasedhouduan.javabean.LinshiuserMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinshiuserMstMapper {
    int countByExample(LinshiuserMstExample example);

    int deleteByExample(LinshiuserMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(LinshiuserMst record);

    int insertSelective(LinshiuserMst record);

    List<LinshiuserMst> selectByExample(LinshiuserMstExample example);

    LinshiuserMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LinshiuserMst record, @Param("example") LinshiuserMstExample example);

    int updateByExample(@Param("record") LinshiuserMst record, @Param("example") LinshiuserMstExample example);

    int updateByPrimaryKeySelective(LinshiuserMst record);

    int updateByPrimaryKey(LinshiuserMst record);

    LinshiuserMst selectLinshi();

    void delete();
}