package com.jq.demo1.controller;

import com.jq.demo1.controller.response.CommonReturnType;
import com.jq.demo1.error.BaseError;
import com.jq.demo1.error.exception.BaseException;
import com.jq.demo1.service.UserService;
import com.jq.demo1.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jq
 * @Date: 2019/1/17 11:38
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("otp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam("telphone") String telphone) {
        //按照一定的规则生成otp验证码
        //将otp验证码同对应用户的手机号关联
        //将otp验证码通过短信通道发送给用户
        return CommonReturnType.create(null);
    }


    @RequestMapping("show")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam("id") Integer id) throws BaseException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel user = userService.getUserById(id);
        if (user == null) {
            throw new BaseException(BaseError.USER_NOT_EXIST);
        }
        return CommonReturnType.create(user);
    }

}
