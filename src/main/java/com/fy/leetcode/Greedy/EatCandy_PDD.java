package com.fy.leetcode.Greedy;

/**
 * @Classname EatCandy_PDD
 * @Description TODO
 * @Date 2021/8/8 19:41
 * @Created by fy
 */
public class EatCandy_PDD {
    public int NumOfEatCandy(int n, int t, int c,int[] arr){//数组arr是n个糖果的甜度
        if(c > n){
            return 0;
        }
        int rst = 0;
        int i = 0;//i指向第一个甜度大于t的糖果后一个，初始值为0;
        int j = 0;//遍历指针
        while (j < n){
            if(arr[j] > t){//甜度大于t，i指向后一个糖果
                j += 1;
                i = j;
            }
            else{
                if(j - i + 1 < c){
                    ++j;//没有达到连续c个
                }
                else{
                    rst += 1;//大于等于c后，没遇到一个甜度小于等于t的糖果，结果就加1
                    ++j;
                }
            }
        }
        return rst;

    }
}
