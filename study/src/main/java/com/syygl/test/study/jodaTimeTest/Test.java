package com.syygl.test.study.jodaTimeTest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

/**
 * Created by sunyy on 2019/12/29.
 */
public class Test {
    public static void main(String[] args) {
        // 明确给出年月日时分秒,同时还可以指定毫秒
        DateTime dateTime = new DateTime(2017, 9, 14, 20, 30, 0);

        // 使用时间戳构造
        DateTime dateTime1 = new DateTime(1505371053358L);

        // 使用字符串构造，使用字符串构造需要自己定义pattern
        String date = "2017-09-14 20:30:00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime2 = dateTimeFormatter.parseDateTime(date);

        // 指定时区构造时间
        DateTime dateTime3 = new DateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai")));



        // JDK
        long currentTimeOfMills = System.currentTimeMillis();
        // Joda Time
        long currentTimeOfMills2 = DateTime.now().getMillis();











    }
}
