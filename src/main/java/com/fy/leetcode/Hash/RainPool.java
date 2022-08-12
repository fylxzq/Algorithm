package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @Classname RainPool
 * @Description TODO
 * @Date 2021/8/5 14:07
 * @Created by fy
 */
public class RainPool {
    public int[] avoidFlood(int[] rains){
        int len = rains.length;
        int[] ans = new int[len];
        HashMap<Integer,Integer> rainMap = new HashMap<Integer, Integer>();
        TreeSet<Integer> sunny_date = new TreeSet<Integer>();//记录晴天的日期
        for(int i = 0; i < len; ++i ){
            if(rains[i] == 0){
                sunny_date.add(i);//将晴天日期添加到treeset中
                ans[i] = 1;
                continue;
            }
            else{
                ans[i] = -1;
            }
            if( !rainMap.containsKey(rains[i])){
                rainMap.put(rains[i],i);
            }
            else{
                Integer t = sunny_date.higher(rainMap.get(rains[i]));
                //上面这一步是找到上次这个湖泊满了以后离他最近的一次晴天
                if(t == null){
                    return new int[0];//如果没有晴天，会发生洪水
                }
                else{
                    ans[t] = rains[i];//找到了晴天，在这个晴天抽水
                }
                sunny_date.remove(t);
                rainMap.put(rains[i],i);
            }
        }
        return ans;
    }
}
