package com.fy.leetcode.Strs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CanChange
 * @Description TODO
 * @Date 2022/7/10 10:57
 * @Created by fy
 */
public class CanChange {
    public boolean canChange(String start, String target) {
        int len = start.length();
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(start.charAt(i) == 'L'){
                list1.add(new int[]{0,i});
            }
            if(start.charAt(i) == 'R'){
                list1.add(new int[]{1,i});
            }
        }
        for(int i = 0; i < len; i++){
            if(target.charAt(i) == 'L'){
                list2.add(new int[]{0,i});
            }
            if(target.charAt(i) == 'R'){
                list2.add(new int[]{1,i});
            }
        }
        if(list1.size() != list2.size()){
            return false;
        }
        for(int i = 0; i < list1.size(); i++){
            int[] arr1 = list1.get(i);
            int[] arr2 = list2.get(i);
            if(arr1[0] != arr2[0]){
                return false;
            }
            else if(arr1[0] == 0 && arr1[1] < arr2[1]){
                return false;
            }
            else if(arr1[0] == 1 && arr1[1] > arr1[1]){
                return false;
            }
        }
        return true;
    }
}
