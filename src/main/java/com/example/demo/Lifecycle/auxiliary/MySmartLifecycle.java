package com.example.demo.Lifecycle.auxiliary;


import org.springframework.context.SmartLifecycle;

public class MySmartLifecycle implements SmartLifecycle {

    private volatile boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("MySmartLifecycle... start");
        System.out.println("-----当前调用堆栈----");
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : elements) {
            System.out.println(element);
        }
        System.out.println("-----当前调用堆栈----");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("MySmartLifecycle... stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
