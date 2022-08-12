package com.fy.leetcode.Array;

/**
 * @Classname Candy
 * @Description TODO
 * @Date 2022/4/29 12:50
 * @Created by fy
 */
public class Candy {
    public int candy(int[] ratings) {
        int res = 1;
        int asc = 1;
        int desc = 0;
        int pre = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] >= ratings[i - 1]){
                desc = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                asc= pre;
            }
            else{
                desc++;
                if(desc == asc){
                    desc++;
                }
                res += desc;
                pre = 1;
            }
        }
        return res;
    }
}
