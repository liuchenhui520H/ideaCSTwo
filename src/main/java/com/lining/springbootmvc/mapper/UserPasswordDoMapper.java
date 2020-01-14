package com.lining.springbootmvc.mapper;

import com.lining.springbootmvc.pojo.UserPasswordDo;
import org.springframework.stereotype.Service;


public interface UserPasswordDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswordDo record);

    int insertSelective(UserPasswordDo record);

    UserPasswordDo selectByUserId(Integer id);

    int updateByPrimaryKeySelective(UserPasswordDo record);

    int updateByPrimaryKey(UserPasswordDo record);
}