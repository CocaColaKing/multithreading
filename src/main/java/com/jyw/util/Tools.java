package com.jyw.util;

/**
 * @author jyw
 * @date 2019/2/24 22:34
 */
public class Tools {
    /**
     * 使当前线程休眠随机时间
     * @param t
     */
    public static void randomPause(int t){
        try {
            Thread.currentThread().sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
