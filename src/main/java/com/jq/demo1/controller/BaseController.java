package com.jq.demo1.controller;

import com.jq.demo1.controller.response.CommonReturnType;
import com.jq.demo1.error.BaseError;
import com.jq.demo1.error.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jq
 * @Date: 2019/1/17 17:23
 */
@RestController
public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception e) {
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
