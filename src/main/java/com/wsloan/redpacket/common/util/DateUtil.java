package com.wsloan.redpacket.common.util;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static final String DATE_YYYYMMDD_PATTER="yyyyMMdd";

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_YYYY_MM_DD_PATTERN="yyyy-MM-dd";

    public String getStringRegDate(String entryDate) {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(entryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 得到60天后的日期
        Date date2 = new Date(date1.getTime() + 60L * 24L * 60L * 60L * 1000L);
        String date3 = format.format(date2);


        return date3;

    }


    public  Integer daysBetween(String entrydate) throws ParseException {
        Date d = new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date date=formatter.parse(entrydate);
        long  week = (d.getTime() - date.getTime())/(24L * 60L * 60L * 1000L*7);
        return Integer.parseInt(String.valueOf(week))+1;
    }

    public String getNewRegDate(String entryDate,int datej) {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(entryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 得到60天后的日期
        Date date2 = new Date(date1.getTime() + (datej) * 24L * 60L * 60L * 1000L);
        String date3 = format.format(date2);
        return date3;
    }

    public   String getSystemTime(){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");//设置日期格式
            String str=df.format(new Date());// new Date()为获取当前系统时间
            return str;
    }


    public  String getSystemSmallTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String str=df.format(new Date());// new Date()为获取当前系统时间
        return str;
    }
    //获取YYYY-MM格式的当前时间
    public static String getYMDate(){
        Date Date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(Date);
    };

    //获取YYYY-MM-DD HH:mm的当前时间
    public static String getYMDHMDate(){
        Date Date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(Date);
    }

    //获取yyyy-MM-dd格式的当前时间
    public static String getYMDDate(){
        Date Date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        return sdf.format(Date);
    }

    //获取yyyy-MM-dd hh:mm:ss格式的当前时间
    public static String getYMDHMSDate(){
        Date Date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(Date);
    }

    //获取yyyy格式的当前时间
    public static String getYDate(){
        Date Date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(Date);
    }

    //获取某月时间的月第一天和下个月的第一天
    public static Map getMonthDate(String Date){
        Map<String,Object> MonthDayDate=new HashMap<String,Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date=null;
        try {
            date = sdf.parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //得到当前时间的下个月
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        Date nextMonDate=cal.getTime();
        String inDate=sdf.format(date);
        String nextDate=sdf.format(nextMonDate);
        //得到这个月的1号和下个月的1号
        MonthDayDate.put("startDate",Date+"-01");
        MonthDayDate.put("endDate",nextDate+"-01");

        return MonthDayDate;
    }


    //获取制定格式的当前时间
    public static String convertDateToString(Date date,String pattern){
        SimpleDateFormat df;
        String returnValue = "";
        if (date != null) {
            df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;

    }
    public static String autoGenericCode(int seq) {
        DecimalFormat df = new DecimalFormat("000");
        String str = df.format(seq);
        return str;
    }
    /**
     * 获取当前时间前或者后N天日期
     * @return
     */
    public static String getNDateByDay(int day) {
        Date date=new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_PATTERN);
        String dateString = formatter.format(date);
        return dateString;
    }
    /**
     * 获取当前时间前或者后N月日期
     * @return
     */
        public static String getNDateByMonth(int month) {
            Date date=new Date();//取时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH,month);//把日期往后增加一天.整数往后推,负数往前移动
            date=calendar.getTime(); //这个时间就是日期往后推一天的结果
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_YYYY_MM_DD_PATTERN);
            String dateString = formatter.format(date);
            return dateString;
      }
    /**
     * 获取某个时间前或者后N天日期
     * @return
     */
    public static String getNDateByMonth(String sdate,int month,String pattern) {
        Date date=convertStringToDate(sdate,pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,month);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(date);
        return dateString;
    }
    /**
     * 获取某个时间前或者后N天日期
     * @return
     */
    public static String getNDateByMonth(Date date,int month,String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,month);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(date);
        return dateString;
    }
    /**
     * 获取当前时间前或者后N年日期
     * @return
     */
    public static String getNDateByYEAR(int year) {
        Date date=new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,year);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_YYYY_MM_DD_PATTERN);
        String dateString = formatter.format(date);
        return dateString;
    }
    /**
     * 日期比较
     * @return
     */
    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat(DATE_YYYY_MM_DD_PATTERN);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    public static Date convertStringToDate(String strDate,String aMask)  {
        SimpleDateFormat df   = new SimpleDateFormat(aMask);
        Date date=null;
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
        }
        return (date);
    }

    /**
     * 给指定日期累加上指定的小时数
     * @author cui
     * @date Jun 26, 2012
     * @param time 日期参数
     * @param add_Hour 累加小时数
     * @return 累加后的日期
     */
    public static Date addHourByDay(Date time, int add_Hour) {

        if (time == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.HOUR_OF_DAY, add_Hour);
        return cal.getTime();
    }

    /**
     * 判断time是否在from，to之内
     *
     * @param time 指定日期
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static boolean belongCalendar(String time, String from, String to) {
        Calendar date = Calendar.getInstance();
        date.setTime(convertStringToDate(time,DATE_TIME_PATTERN));

        Calendar after = Calendar.getInstance();
        after.setTime(convertStringToDate(from,DATE_TIME_PATTERN));

        Calendar before = Calendar.getInstance();
        before.setTime(convertStringToDate(to,DATE_TIME_PATTERN));

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean belongCalendar(String time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(convertStringToDate(time,DATE_TIME_PATTERN));

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断time是否在from，to之内
     *
     * @param time 指定日期
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 判断time是否在from，to之内
     *
     * @param one 指定日期
     * @param two 开始日期
     * @return
     */
    public static boolean comporeTwoDate(String one, String two,String pattern) {
        Calendar date = Calendar.getInstance();
        date.setTime(convertStringToDate(one,pattern));

        Calendar after = Calendar.getInstance();
        after.setTime(convertStringToDate(two,pattern));


        if (date.after(after) ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 日期比较
     * @return
     */
    public static int compareDateTime(Date d1, Date d2) {
        DateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN);
        try {
            if (d1.getTime() > d2.getTime()) {
                //System.out.println("d1 在d2前");
                return 1;
            } else if (d1.getTime() < d2.getTime()) {
                //System.out.println("d1在d2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 当前时间减或加n分钟
     * @param n
     */
    public static String offsetMinute(int n){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, n);
        return sdf.format(nowTime.getTime());
    }

    public  static void main(String[] args){
        System.out.println(offsetMinute(-5));
    }
}
