package com.lining.springbootmvc.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.lining.springbootmvc.mapper.UserDoMapper;
import com.lining.springbootmvc.mapper.UserPasswordDoMapper;
import com.lining.springbootmvc.pojo.UserDo;
import com.lining.springbootmvc.pojo.UserPasswordDo;
import com.lining.springbootmvc.service.UserService;
import com.lining.springbootmvc.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDoMapper userDoMapper;
    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;
    @Override
    public UserModel getUserById(Integer id) {

        UserDo userDo= userDoMapper.selectByPrimaryKey(id);
        if(userDo==null){
        return null;
         }
        UserPasswordDo userPasswordDo=userPasswordDoMapper.selectByUserId(userDo.getId());
        return converFromDateObject(userDo,userPasswordDo);
    }

    public UserModel converFromDateObject(UserDo userDo, UserPasswordDo userPasswordDo){
        if(userDo==null){
            return null;
        }
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDo,userModel);
        if(userPasswordDo!=null){
            userModel.setPassword(userPasswordDo.getPassword());
        }

        return userModel;
    }
}
