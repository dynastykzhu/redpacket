package com.wsloan.redpacket.controller;

import com.wsloan.redpacket.common.base.JsonResult;
import com.wsloan.redpacket.common.util.GetMonery;
import com.wsloan.redpacket.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "注册接口", value = "")
@Scope("prototype")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private LoginService loginService;


    @ApiOperation(value = "注册活动", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "openId", value = "微信openId", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "微信名称", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "cmtel", value = "手机号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "pictureCode", value = "图片验证吗", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "shortMessageCode", value = "短信验证吗", required = true, dataType = "string"),
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(String openId, String name, String cmtel, String pictureCode, String shortMessageCode) {
        JsonResult result = null;
        result = loginService.registerSer(openId, name, cmtel, pictureCode, shortMessageCode);
        return result;
    }

    @ApiOperation(value = "拆红包", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "openIdAccept", value = "接受红包的微信openId", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "nameAccept", value = "接收红包的名称", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "openIdSend", value = "发送红包的微信opendId", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "nameSend", value = "发送红包的名称", required = false, dataType = "string"),
    })
    @RequestMapping(value = "/openRedPacket", method = RequestMethod.POST)
    public JsonResult openRedPacket(String openIdAccept, String nameAccept, String openIdSend, String nameSend) {
        JsonResult result = null;
        result = loginService.openRedPacketSer(openIdAccept, nameAccept, openIdSend, nameSend);
        return result;
    }


    @ApiOperation(value = "分享红包", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "openIdSend", value = "发送红包的微信opendId", required = true, dataType = "string"),
    })
    @RequestMapping(value = "/shareRedPacket", method = RequestMethod.POST)
    public JsonResult shareRedPacket(String openIdSend) {
        JsonResult result = null;
        result = loginService.shareRedPacketSer(openIdSend);
        return result;
    }
}
