package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname RepeatedSubstringPattern
 * @Description TODO
 * @Date 2022/5/12 15:39
 * @Created by fy
 */
public class RepeatedSubstringPattern {
    @Test
    public void test(){
        repeatedSubstringPattern("aba");
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1; i <= len / 2; i++){
            if(len % i == 0){
                String substr = s.substring(0,i);
                boolean match = true;
                for(int j = 0; j < len % i; j++){
                    if(!s.substring(j * i, (j + 1) * i).equals(substr)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }
}
