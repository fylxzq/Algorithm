package com.fy.leetcode.RelativeSort;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Classname GetReturnDate
 * @Description TODO
 * @Date 2022/4/15 19:22
 * @Created by fy
 */
public class GetReturnDate {

    @Test
    public void test() throws ParseException {
        getReturnDate("20220109,20220101");
    }

    public String getReturnDate(String loginDates) {
        // write code here
        String[] logindatesArr = loginDates.split(",");
        Arrays.sort(logindatesArr);
        if(logindatesArr.length < 1){
            return null;
        }
        String res = "null";
        for(int i = 1; i < logindatesArr.length ; i++){
            int gapday = gapDays(logindatesArr[i - 1],logindatesArr[i]);
            if(gapday > 7){
                res = logindatesArr[i];
            }
        }
        return res;
    }

    private int gapDays(String s1,String s2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long timestamp1 = 0;
        long timestamp2 = 0;
        try {
            timestamp1 = sdf.parse(s1).getTime() / 1000;
            timestamp2 = sdf.parse(s2).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long gapDays = (timestamp2 - timestamp1) / (60 * 60 * 24);
        return (int) gapDays;
    }

}
