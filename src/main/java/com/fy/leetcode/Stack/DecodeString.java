package com.fy.leetcode.Stack;

import org.junit.Test;

import java.util.*;

/**
 * @Classname DecodeString
 * @Description TODO
 * @Date 2022/2/27 9:39
 * @Created by fy
 */
public class DecodeString {
    @Test
    public void test() {
        String s = "172.16.254.1.";
        System.out.println(Arrays.toString(s.split("\\.",-1)));
    }
    public String decodeString(String s) {
        Deque<Integer> num_stack = new LinkedList<>();
        Deque<String> char_stack = new LinkedList<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        int val = 0;
        int index = 0;
        while (index < s.length()) {
            Character e = s.charAt(index);
            if (Character.isDigit(e)) {
                while (Character.isDigit(e)) {
                    val = val * 10 + e - '0';
                    e = s.charAt(++index);
                }
                num_stack.push(val);
                val = 0;
            } else if (e != ']') {
                char_stack.push(e.toString());
                ++index;
            } else {
                List<String> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                int count = num_stack.pop();
                String cur_str;
                while (!"[".equals(cur_str = char_stack.pop())) {
                    list.add(cur_str);
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    sb.append(list.get(i));
                }
                String tmpStr = sb.toString();
                for (int i = 0; i < count - 1; i++) {
                    sb.append(tmpStr);
                }
                char_stack.push(sb.toString());
                ++index;
            }

        }
        StringBuilder res = new StringBuilder();
        while (!char_stack.isEmpty()){
            res.append(char_stack.pollLast());
        }
        return res.toString();

    }
}
