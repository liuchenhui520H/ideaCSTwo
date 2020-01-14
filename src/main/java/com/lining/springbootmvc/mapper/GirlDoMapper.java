package com.lining.springbootmvc.mapper;

import com.lining.springbootmvc.pojo.GirlDo;

public interface GirlDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GirlDo record);

    int insertSelective(GirlDo record);

    GirlDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GirlDo record);

    int updateByPrimaryKey(GirlDo record);
}