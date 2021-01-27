package com.zhh.algorithm.exercise.stack;


public class ArrayStack {

    private int[] array;
    private int length;
    private int count;


    public ArrayStack(int length){
        array = new int[length];
        this.length = length;
        count = 0;
    }

    public int poll(){
        if(count == 0 ){
            resise();
        }
        return array[--count];
    }

    public boolean push(int ele){
        if(count == length){
            return false;
        }
        array[count] = ele;
        count++;
        return true;
    }

    /**
     * 动态扩容
     */
    private void resise(){
        int[] temp  = new int[length * 2];
        for (int i = 0; i < length; i++) {
            temp[i] = array[i];
        }
        length = length * 2;
        array = temp;
    }

}
