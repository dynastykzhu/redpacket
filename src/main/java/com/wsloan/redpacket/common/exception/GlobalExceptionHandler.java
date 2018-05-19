package com.wsloan.redpacket.common.exception;

import com.wsloan.redpacket.common.base.ApiResult;
import com.wsloan.redpacket.common.base.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常类定义
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult handler(Exception e)
    {
         if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ApiResult.error(myException.getResultEnum());
        } else {
            logger.error("系统异常:", e);
            return ApiResult.error(ResultEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}