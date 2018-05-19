package com.wsloan.redpacket.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class GetMonery {

    public static String redpacketMoneyMax;
    public static String redpacketMoneyMin;

    @Value("${REDPACKET_MONEY.MAX}")
    public void setRedpacketMoneyMax(String redpacketMoneyMax) {
        GetMonery.redpacketMoneyMax = redpacketMoneyMax;
    }
    @Value("${REDPACKET_MONEY.MIN}")
    public void setRedpacketMoneyMin(String redpacketMoneyMin) {
        GetMonery.redpacketMoneyMin = redpacketMoneyMin;
    }

    public static Double getRandom() {

        DecimalFormat myformat = new DecimalFormat("#0.00");
        double sz = (double) (Math.random() * (Double.parseDouble(redpacketMoneyMax) - Double.parseDouble(redpacketMoneyMin))) + Double.parseDouble(redpacketMoneyMin);
        return Double.parseDouble(myformat.format(sz));
    }


}
