package com.jq.demo1.error;

/**
 * @Author: jq
 * @Date: 2019/1/17 15:32
 */
public enum BaseError implements CommentError {
    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    //未知错误类型10002
    UNKNOWN_ERROR(10002, "未知错误"),
    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在");
    ;
    private BaseError(int code,String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    }
    private int code;
    private String errMsg;
    @Override
    public int getErrCode() {
        return this.code;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommentError setErrMsg(String msg) {
        this.errMsg = msg;
        return this;
    }
}
