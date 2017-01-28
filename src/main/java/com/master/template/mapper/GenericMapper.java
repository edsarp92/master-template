package com.master.template.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Edsarp on 2/16/2016.
 */

public interface GenericMapper<Model,Example,PK> {

    long countByExample(Example criteria);

    int deleteByExample(Example criteria);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> selectByExample(Example criteria);

    Model selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") Example example);

    int updateByExample(@Param("record") Model record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}
