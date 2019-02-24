package com.jyw.base;

/**
 * User:jyw
 * Date:2019/2/24
 * Time:21:43
 * Create by IntelliJ IDEA
 *
 * @author jyw
 * 创建线程的两种方法
 */
public class WelcomeApp {
    public static void main(String[] args) {
        // 创建线程
        Thread welcomeThread = new WelcomeThread();
        Thread welcomeTask = new Thread(new WelcomeTask());
        // 启动线程
        welcomeThread.start();
        welcomeTask.start();
        // 输出“当前”线程的名称
        System.out.printf("1.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}

/**
 * 1、继承Thread类
 * 定义Thread的子类
 */
class WelcomeThread extends Thread {
    // 在run方法中实现线程的任务处理逻辑
    @Override
    public void run() {
        System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}

/**
 * 2、实现Runnable接口
 */
class WelcomeTask implements Runnable {

    public void run() {
        System.out.printf("3.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}

