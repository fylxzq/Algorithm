package com.fy.leetcode.Array;

import org.junit.Test;

/**
 * @Classname Compress
 * @Description TODO
 * @Date 2022/3/29 9:02
 * @Created by fy
 */
public class Compress {

    @Test
    public int compress(char[] chars) {
        int len = chars.length;
        if(len == 1 || len == 2){
            return len;
        }
        char pre = chars[0];
        int count = 1;
        int p = 0;
        for(int i = 1;i <= len; i++){
            if(i < len && chars[i] == pre){
                ++count;
            }
            else{
                chars[p++] = pre;
                while(count != 0){
                    chars[p++] = (char) (count % 10);
                    count /= 10;
                }
                count = 1;
                pre = chars[i];
            }
        }
        return p - 1;
    }
}
