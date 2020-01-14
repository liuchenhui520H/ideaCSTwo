package com.lining.springbootmvc;

import com.lining.springbootmvc.mapper.UserDoMapper;
import com.lining.springbootmvc.pojo.UserDo;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.lining.springbootmvc"})//扫描包
@MapperScan("com.lining.springbootmvc.mapper")
@RestController
public class SpringbootmvcApplication {

    @Autowired
    private UserDoMapper userDoMapper;

    @RequestMapping("/")
    public String home(){
        UserDo userDo= userDoMapper.selectByPrimaryKey(1);
        if(userDo==null){
            return "用户不存在！";
        }else {
            return userDo.getName();
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmvcApplication.class, args);
    }

}
