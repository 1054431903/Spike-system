package com.jq.demo1.controller;

import com.jq.demo1.dao.UserDOMapper;
import com.jq.demo1.dataObject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jq
 * @Date: 2019/1/17 10:43
 */
@RestController
@RequestMapping("/")
public class RunFirst {
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("index")
    @ResponseBody
    public UserDO start() {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        return userDO;
    }
}
