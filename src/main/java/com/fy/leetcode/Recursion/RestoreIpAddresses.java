package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RestoreIpAddresses
 * @Description TODO
 * @Date 2022/1/16 15:43
 * @Created by fy
 */
public class RestoreIpAddresses {
    List<String> rst = new ArrayList<>();


    @Test
    public void test(){
        String s = "1111";
        restoreIpAddresses(s);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> tmprst = new ArrayList<>();
        dfs(s,0,tmprst);
        return rst;
    }
    public void dfs(String s,int begin,List<String> tmprst){
        for(int i = 1;i <= 3; ++i){
            if(begin + i > s.length()){
                return;
            }
            else{
                String tmpstr = s.substring(begin,begin + i);
                if( !ifValid(tmpstr )){
                    return;
                }
                else{
                    tmprst.add(tmpstr);
                    if(tmprst.size() < 4){
                        dfs(s, begin + i,tmprst);
                    }
                    else if(tmprst.size() == 4 && begin + i == s.length()){
                        StringBuilder sb = new StringBuilder();
                        for(int j = 0; j < 4;++j){
                            sb.append(tmprst.get(i));
                            if(j < 3){
                                sb.append(".");
                            }
                        }
                        rst.add(sb.toString());
                    }
                    tmprst.remove(tmprst.size());
                }
            }
        }
    }

    public boolean ifValid(String s){
        if(s.length() == 1){
            return true;
        }
        else if(Integer.parseInt(s) > 255){
            return false;
        }
        else if(s.charAt(0) == '0'){
            return false;
        }
        else{
            return true;
        }
    }
}
