package com.example.demo.util;

import org.springframework.util.StopWatch;

//耗时监控
public class StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("aaa");
        Thread.sleep(100);
        assert stopWatch.isRunning();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.getLastTaskInfo().toString());
    }
}
