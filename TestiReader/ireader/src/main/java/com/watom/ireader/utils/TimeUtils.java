package com.watom.ireader.utils;

public class TimeUtils {

    private static TimeUtils utt = new TimeUtils();

    private TimeUtils() {
    }

    public static TimeUtils getInstance() {
        return utt;
    }

    private long start;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        long end = System.currentTimeMillis();
        System.out.println("所用时间 : " + (end - start) + "毫秒");
    }
}
