package com.lining.springbootmvc.mapper;

import com.lining.springbootmvc.pojo.UserDo;
import org.springframework.stereotype.Service;


public interface UserDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}