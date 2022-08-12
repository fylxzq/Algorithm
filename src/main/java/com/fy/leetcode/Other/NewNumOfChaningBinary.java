package com.fy.leetcode.Other;

import org.junit.Test;

/**
 * @Classname NewNumOfChaningBinary
 * @Description TODO
 * @Date 2021/8/16 9:53
 * @Created by fy
 */
public class NewNumOfChaningBinary {

    public int get_newnum(int x){
        int tmp_x = x;
        int count = 0;
        int incresement = 1;
        while (x != 0){
            int extra = x % 2;
            x = x / 2;
            if(extra == 0){
                if(++count == 2){
                    return tmp_x + incresement;
                }
            }
            incresement = incresement * 2;

        }
        return tmp_x;
    }
}
