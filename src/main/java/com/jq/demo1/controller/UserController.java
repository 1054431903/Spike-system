package com.jq.demo1.controller;

import com.jq.demo1.controller.response.CommonReturnType;
import com.jq.demo1.error.BaseError;
import com.jq.demo1.error.CommentError;
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
public class UserController {

    @Autowired
    private UserService userService;

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

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request,Exception e) {
        Map<String, Object> data = new HashMap<>();
        if(e instanceof BaseException) {
            BaseException exception = (BaseException) e;
            data.put("errCode", exception.getErrCode());
            data.put("errMsg", exception.getErrMsg());
        }else {
            data.put("errCode", BaseError.UNKNOWN_ERROR.getErrCode());
            data.put("errMsg", BaseError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(data, "fail");
    }
}
