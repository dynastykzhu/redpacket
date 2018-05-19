package com.wsloan.redpacket.service.impl;


import com.wsloan.redpacket.common.base.JsonResult;
import com.wsloan.redpacket.common.base.ResultEnum;
import com.wsloan.redpacket.common.exception.MyException;
import com.wsloan.redpacket.common.util.GetMonery;
import com.wsloan.redpacket.dao.mysql.TRewardsMapper;
import com.wsloan.redpacket.dao.mysql.TUserMapper;
import com.wsloan.redpacket.entity.TRewards;
import com.wsloan.redpacket.entity.TUser;
import com.wsloan.redpacket.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private TUserMapper tUserMapper;
    @Resource
    private TRewardsMapper tRewardsMapper;
//    @Value("${REDPACKET_MONEY.MAX}")
//    public String redpacketMoneyMax;
//    @Value("${REDPACKET_MONEY.MIN}")
//    public String redpacketMoneyMin;


    @Override
    @Transactional
    public JsonResult registerSer(String openId, String name, String cmtel, String pictureCode, String shortMessageCode) {

        TUser tUser = tUserMapper.selectByPrimaryKey(openId);
        if (tUser != null) {
            return new JsonResult(ResultEnum.REPEATED_REGISTER);//可以记录个日志
        }
        /**
         * 调。net接口返回金额
         */

        double money = 9.0;
        Date date = new Date();
        TUser tUser1 = new TUser(openId, name, cmtel, BigDecimal.valueOf(money), BigDecimal.valueOf(money), date);
        int i = tUserMapper.insert(tUser1);
        TRewards tRewards = new TRewards(openId, name, BigDecimal.valueOf(money), "0", "温商贷App惊喜红包", BigDecimal.valueOf(0), date);
        tRewardsMapper.insertSelective(tRewards);
        TUser tUser2 = tUserMapper.selectByPrimaryKey(openId);
        Map m = getInfo(tUser2);
        return new JsonResult(m);
    }

    @Override
    @Transactional
    public JsonResult openRedPacketSer(String openIdAccept, String nameAccept, String openIdSend, String nameSend) throws MyException {

        if (StringUtils.isEmpty(openIdSend)) {
            TUser tUser = tUserMapper.selectByPrimaryKey(openIdAccept);
            if (tUser == null) {//没有注册过活动,进入注册页面
                return new JsonResult(ResultEnum.NO_REGISTER);
            } else {//否则返回当前获得的奖励和红包记录
                Map m = getInfo(tUser);
                return new JsonResult(m);
            }
        } else {
            TUser tUserAccept = tUserMapper.selectByPrimaryKey(openIdAccept);
            TUser tUserSend = tUserMapper.selectByPrimaryKey(openIdSend);
            if (tUserAccept == null || tUserSend==null) {
                return new JsonResult(ResultEnum.NO_REGISTER);//可以记录个日志
            }
            //已经拆过红包，不能再拆
            if (tRewardsMapper.selectByOpenIdAcceptAndopenIdSend(openIdAccept, openIdSend) > 0) {
                return new JsonResult(ResultEnum.REPEATED_PACK);
            }
            //1天只能拆5次红包
            if (tRewardsMapper.selectNumByOpenIdAcceptOneDay(openIdAccept) >= 5) {
                return new JsonResult(ResultEnum.OVER_LIMIT);
            }
            Date date = new Date();
            double moneyAccept = GetMonery.getRandom();
            double moneySend = GetMonery.getRandom();
            //.net接口


            TRewards tRewards = new TRewards(openIdAccept, nameAccept, BigDecimal.valueOf(moneyAccept),
                    openIdSend, nameSend, BigDecimal.valueOf(moneySend), date);
            tRewardsMapper.insertSelective(tRewards);

            TUser tUserAccept2 = new TUser(openIdAccept, BigDecimal.valueOf(moneyAccept), BigDecimal.valueOf(moneyAccept));
            tUserMapper.updateByPrimaryKeySome(tUserAccept2);
            TUser tUserSend2 = new TUser(openIdSend, BigDecimal.valueOf(moneySend), BigDecimal.valueOf(moneySend));
            tUserMapper.updateByPrimaryKeySome(tUserSend2);
            tUserAccept = tUserMapper.selectByPrimaryKey(openIdAccept);
            Map m = getInfo(tUserAccept);
            return new JsonResult(m);
        }

    }

    @Override
    public JsonResult shareRedPacketSer(String openIdSend) {
        TUser tUser = tUserMapper.selectByPrimaryKey(openIdSend);
        Map m = getInfo(tUser);
        return new JsonResult(m);
    }


    private Map getInfo(TUser tUser) {
        Map m = new HashMap();
        m.put("tUser", tUser);
        m.put("redRecord", tRewardsMapper.selectByOpenIdAccept(tUser.getOpenId()));
        return m;
    }
}
