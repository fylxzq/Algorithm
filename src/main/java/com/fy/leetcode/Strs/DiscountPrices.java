package com.fy.leetcode.Strs;

/**
 * @Classname DiscountPrices
 * @Description TODO
 * @Date 2022/5/29 10:41
 * @Created by fy
 */
public class DiscountPrices {
    public String discountPrices(String sentence, int discount) {
        double discountD = 1.0 - (double) discount / 100.0;
        StringBuilder sb = new StringBuilder();
        String[] strings = sentence.split(" ");
        for(String str : strings){
            if(str.length() <= 1 || str.charAt(0) != '$'){

            }
            else if(str.charAt(0) == '$'){
                try {
                    double val = Double.parseDouble(str.substring(1,str.length()));
                    String s = String.format("%.2f", val * discountD);
                    sb.append("$" + s + " ");
                }
                catch (NumberFormatException e){
                    sb.append(str+" ");
                }
            }
        }
        return sb.substring(0,sb.length() -1);
    }

}
