package com.zhh.algorithm.exercise.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leedCode 155 最小栈：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 利用两个stack来实现
 */
public class MinStackWithTwoStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStackWithTwoStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
       stack.push(x);
       minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
       stack.pop();
       minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
