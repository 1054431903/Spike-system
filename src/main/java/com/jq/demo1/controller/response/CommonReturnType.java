package com.jq.demo1.controller.response;

/**
 * @Author: jq
 * @Date: 2019/1/17 15:09
 */
public class CommonReturnType {

    //状态信息（表明请求返回的处理结果success  or  fail）
    private String status;
    //携带的相应数据
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
