package com.wsloan.redpacket.service;

import com.wsloan.redpacket.common.base.JsonResult;



public interface LoginService {


    JsonResult registerSer(String openId,String name, String cmtel, String pictureCode, String shortMessageCode);

    JsonResult openRedPacketSer(String openIdAccept, String nameAccept, String openIdSend, String nameSend);

    JsonResult shareRedPacketSer(String openIdSend);
}
