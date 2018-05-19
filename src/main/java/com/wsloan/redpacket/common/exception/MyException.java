package com.wsloan.redpacket.common.exception;


import com.wsloan.redpacket.common.base.ResultEnum;

/**
 * 自定义异常类定义
 */
public class MyException extends RuntimeException {

    private ResultEnum resultEnum;

    public MyException(ResultEnum resultEnum){
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum()
    {
        return resultEnum;
    }

}