package com.jq.demo1.controller;

import com.jq.demo1.service.UserService;
import com.jq.demo1.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jq
 * @Date: 2019/1/17 11:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    @ResponseBody
    public UserModel getUser(@RequestParam("id") Integer id) {
        //调用service服务获取对应id的用户对象并返回给前端
        return userService.getUserById(id);
    }
}
