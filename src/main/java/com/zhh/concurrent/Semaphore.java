package com.zhh.concurrent;

import java.util.Queue;

public class Semaphore {
    private int count;
    private Queue queue;

    public Semaphore(int count) {
        this.count = count;
    }

    public void down(){
        count--;
        if(count < 0){
            // 将当前线程加入到等待队列
            // 阻塞当前线程
        }
    }

    public void up(){
        count++;
        if(count <= 0){
            // 移除等待队列中的线程T
            // 唤醒线程T
        }
    }
}
