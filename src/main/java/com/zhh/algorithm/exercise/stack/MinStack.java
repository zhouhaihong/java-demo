package com.zhh.algorithm.exercise.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    private Deque<Integer> stack = new LinkedList<>();
    private int min;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(stack.size() == 0){
            min = x;
        }else{
            if(x < min){
                min = x;
            }
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.size() == 0){
            return;
        }
        if(stack.size() == 1){
            stack.pop();
            min = -1;
            return;
        }
        Integer ele = stack.pop();
        if(min == ele){
            Iterator<Integer> iter = stack.iterator();
            min = iter.next();
            while (iter.hasNext()){
                Integer next = iter.next();
                if(next < min){
                    min = next;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
