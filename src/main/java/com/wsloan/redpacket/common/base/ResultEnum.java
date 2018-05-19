/**
 * Copyright (C), 2015-2018, 李山聚财网络科技有限公司
 */
package com.wsloan.redpacket.common.base;

/**
 * message统一定义枚举类
 */
public enum ResultEnum
{
    NO_LOGIN (1, "用户未登录"),
    NO_PERMISSION(2, "用户没有权限"),
    CHECK_FAIL(3, "不能为空"),
    OPERATION_FAIL(400, "操作失败"),
    DATA_ERROR(401, "参数数据错误"),
    DATA_DELED(404, "数据不存在"),
    TIMEOUT_CODE_VALUE(999,"请求超时"),
    GROUP_EXIST_ERROR(700,"功能在组合中已存在，删除失败"),
    SYSTEM_ERROR(-1, "系统异常"),
    INIT_FAIL(500,"规则初始化失败"),
    NO_REGISTER(1,"未注册"),
    REPEATED_REGISTER(1,"该微信id已注册过该活动"),
    REPEATED_PACK(1,"不能重复拆同1个人红包"),
    OVER_LIMIT(1,"1天内不能拆超过5个红包");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return  this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
