package com.jq.demo1.error;

/**
 * @Author: jq
 * @Date: 2019/1/17 15:30
 */
public interface CommentError {
    int getErrCode();

    String getErrMsg();

    CommentError setErrMsg(String msg);
}
