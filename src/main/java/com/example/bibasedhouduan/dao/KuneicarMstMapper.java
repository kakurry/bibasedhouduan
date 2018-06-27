package com.example.bibasedhouduan.dao;

import com.example.bibasedhouduan.javabean.KuneicarMst;
import com.example.bibasedhouduan.javabean.KuneicarMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KuneicarMstMapper {
    int countByExample(KuneicarMstExample example);

    int deleteByExample(KuneicarMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(KuneicarMst record);

    int insertSelective(KuneicarMst record);

    List<KuneicarMst> selectByExample(KuneicarMstExample example);

    KuneicarMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KuneicarMst record, @Param("example") KuneicarMstExample example);

    int updateByExample(@Param("record") KuneicarMst record, @Param("example") KuneicarMstExample example);

    int updateByPrimaryKeySelective(KuneicarMst record);

    int updateByPrimaryKey(KuneicarMst record);
}