package com.lining.springbootmvc.Controller;

import com.lining.springbootmvc.pojo.Resource;
import com.lining.springbootmvc.pojo.UserDo;
import com.lining.springbootmvc.service.UserService;
import com.lining.springbootmvc.service.model.UserModel;
import com.lining.springbootmvc.util.LeeJSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Resource resource;

    @RequestMapping("/get")
    @ResponseBody
    public UserModel getUser(@RequestParam(name="id") Integer id){
        UserModel userModel= userService.getUserById(id);
        return userModel;
    }

    @RequestMapping("/csdemo")
    public String getUser(){
        System.out.println("ddddd");
        return "html/myhtml";
    }
    @RequestMapping("/csdemotwo")
    public String csdemotwo(){
        System.out.println("ss");
        return "begin/login";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public UserDo hello(){
        UserDo userDo=new UserDo();
        userDo.setName("小刘");
        userDo.setAge(10);

        userDo.setGender((byte) 'A');

        userDo.setTelphone("136666666");
        return userDo;
    }
    @RequestMapping("/getuserJson")
    @ResponseBody
    public LeeJSONResult getuserJson(){
        UserDo userDo=new UserDo();
        userDo.setName("小刘111");
        userDo.setAge(888);

       // userDo.setGender((byte) 'A');
        userDo.setBirthday(new Date());
        userDo.setTelphone("7777");
        return new LeeJSONResult(userDo);
    }

    @RequestMapping("/getResource")
    @ResponseBody
    public LeeJSONResult getResource(){
        Resource bean=new Resource();
        BeanUtils.copyProperties(resource,bean);
        System.out.println("dddddddd");
        return new LeeJSONResult(bean);
    }

}
