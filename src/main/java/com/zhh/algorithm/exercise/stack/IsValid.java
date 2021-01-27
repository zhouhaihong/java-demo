package com.zhh.algorithm.exercise.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * leetCode 20. 有效的括号(栈在括号匹配中的应用)
 *
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {

    public boolean isValid(String s) {
      int len = s.length();
      if(len % 2 == 1){
          return false;
      }
      HashMap<Character, Character> charMap = new HashMap<>();
      charMap.put(')', '(');
      charMap.put('}', '{');
      charMap.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(charMap.containsKey(ch)){
                if(stack.isEmpty() || stack.pop()!= charMap.get(ch)){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
