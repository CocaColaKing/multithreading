package com.jyw.base;

import com.jyw.util.Tools;

/**
 * @author jyw
 * @date 2019/2/24 22:28
 * 线程的两种创建方式的区别
 * 实现Runnable接口的创建方式意味着多个线程实例可以共享同一个Runnable实例。
 * 如果是8核处理器
 * CountingTask后面的数字可能小于800（=8*100）
 * 而CountingThread后面的数字始终都是100
 */
public class ThreadCreationCmp {
    public static void main(String[] args) {
        Thread t;
        CountingTask ct = new CountingTask();
        // 获取处理器个数
        final int numberOfProceesors = Runtime.getRuntime().availableProcessors();
        System.out.println(numberOfProceesors);
        for (int i = 0; i < numberOfProceesors; i++) {
            // 直接创建线程
            t = new Thread(ct);
            t.start();
        }
        for (int i = 0; i < numberOfProceesors; i++) {
            // 以子类的方式创建线程
            t = new CountingThread();
            t.start();
        }
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int value() {
            return count;
        }
    }

    static class CountingTask implements Runnable {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingTask:" + counter.value());
        }

        private void doSomething() {
            Tools.randomPause(80);
        }
    }

    static class CountingThread extends Thread {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingThread:" + counter.value());
        }

        private void doSomething() {
            Tools.randomPause(80);
        }
    }

}
