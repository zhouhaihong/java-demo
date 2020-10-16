package com.zhh.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static int count = 0;
    // 1表示只能有一个线程加入临界区，实现互斥的效果
    public static final Semaphore sem = new Semaphore(1);

    public static void addOneSem(){
        try {
            sem.acquire();
            count ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            sem.release();
        }

    }

    public static void addOne(){
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count=" + count);
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            SemaphoreExample.addOneSem();
        }
    }
}

