package com.jq.demo1.error;

/**
 * @Author: jq
 * @Date: 2019/1/17 15:30
 */
public interface CommonError {
    int getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String msg);
}
