package com.jq.demo1.error.exception;

import com.jq.demo1.error.CommentError;

/**
 * @Author: jq
 * @Date: 2019/1/17 15:51
 */
//包装器业务异常类实现
public class BaseException extends Exception implements CommentError {

    private CommentError commentError;

    //直接接收CommentError 的传参用于构造业务异常
    public BaseException(CommentError commentError) {
        super();
        this.commentError = commentError;
    }

    //接收自定义errMsg的方式构造业务异常
    public BaseException(CommentError commentError, String msg) {
        super();
        this.commentError = commentError;
        this.commentError.setErrMsg(msg);
    }

    @Override
    public int getErrCode() {
        return this.commentError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commentError.getErrMsg();
    }

    @Override
    public CommentError setErrMsg(String msg) {
        this.commentError.setErrMsg(msg);
        return this;
    }

}
