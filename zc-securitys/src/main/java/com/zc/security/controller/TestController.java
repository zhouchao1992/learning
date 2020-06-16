package com.zc.security.controller;

import com.zc.security.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags="测试")
@Controller
@RequestMapping("/test/api/data/")
public class TestController {


    @ApiOperation("获取数据集合")
    @GetMapping("list")
    public Object listData(){
        List<String> listdata = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            listdata.add("骄傲和数据库到法律手dfsd段开发商");
        }
        return listdata;
    }

    @ApiOperation("登录接口")
    @PostMapping("login")
    public User login(String username,String password){
        if ("admin".equals(username)  && "123456".equals(password)){
            User user = new User();
            user.setId("1");
            user.setUsername("admin");
            user.setPassword("123456");
            return user;
        }else {
            return  new User();
        }

    }




}
