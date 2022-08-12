package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DecodeMessage
 * @Description TODO
 * @Date 2022/7/3 10:33
 * @Created by fy
 */
public class DecodeMessage {
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        char[] keys = key.toCharArray();
        char tmp = 'a';
        for(char e : keys){
            if(e != ' '){
                if(!map.containsKey(e)){
                    map.put(e, tmp++);
                }
            }
        }
        char[] messages = message.toCharArray();
        for(int i = 0; i < messages.length; i++){
            char e = messages[i];
            if(map.containsKey(e)){
                messages[i] = map.get(e);
            }
        }
        return String.valueOf(messages);
    }
}
