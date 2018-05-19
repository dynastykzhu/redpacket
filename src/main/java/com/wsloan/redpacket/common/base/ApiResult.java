/**
 * Copyright (C), 2015-2018, 李山聚财网络科技有限公司
 */
package com.wsloan.redpacket.common.base;

import java.io.Serializable;

/**
 * 结果封装类
 *
 * @author fengchen
 * 2017-11-17 13:22:30
 */
public class ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 0;

    private int code = SUCCESS;
    private String message = "操作成功";
    private Object content;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getContent()
    {
        return content;
    }

    public void setContent(Object content)
    {
        this.content = content;
    }

    public ApiResult(){
        super();
    }

    public ApiResult(Object content){
        super();
        this.content = content;
    }

    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiResult success(){
        return new ApiResult();
    }

    public static ApiResult success(Object object){
        return new ApiResult(object);
    }

    public static ApiResult error(ResultEnum enu){
        return new ApiResult(enu.getCode(), enu.getMsg());
    }

    public static ApiResult error(ResultEnum enu, String fieldName){
        return new ApiResult(enu.getCode(), fieldName + " " + enu.getMsg());
    }
}
