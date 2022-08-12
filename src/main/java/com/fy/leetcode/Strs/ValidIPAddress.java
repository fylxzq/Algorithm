package com.fy.leetcode.Strs;

/**
 * @Classname validIPAddress
 * @Description TODO
 * @Date 2022/4/15 14:23
 * @Created by fy
 */
public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if(isValidIpv4(queryIP)){
            return "IPv4";
        }
        else if(isValidIpv6(queryIP)){
            return "IPv6";
        }
        else{
            return "Neither";
        }
    }

    private boolean isValidIpv4(String queryIp){
        String[] split = queryIp.split("\\.");
        if(split.length != 4){
            return false;
        }
        for(String str : split){
            if(str.length() <= 0){
                return false;
            }
            if(str.charAt(0) == '0' && str.length() > 1){
                return false;
            }
            try {
                int num = Integer.parseInt(str);
                if(num < 0 || num > 255){
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIpv6(String queryIp){
        String[] split = queryIp.split(":");
        if(split.length != 8){
            return false;
        }
        for(String str : split){
            if(str.length() <= 0 || str.length() > 4){
                return false;
            }
            try {
                int num = Integer.parseInt(str,16);
                if(num < 0 || num > 65535){
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
