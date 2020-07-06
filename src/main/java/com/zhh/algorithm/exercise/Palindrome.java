
package com.zhh.algorithm.exercise;

/**
 * 判断给定字符串是否是回文字符串
 * @Description:
 * @Author: zhh
 * @Date: 2019/6/19
 */
public class Palindrome {

    public static boolean isPalindrome(String str){
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length-1; i < chars.length; i++,j--) {
            if(chars[i] != chars[j]){
                return false;
            }else if(i<=j){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("hhdfhh"));
    }
}
