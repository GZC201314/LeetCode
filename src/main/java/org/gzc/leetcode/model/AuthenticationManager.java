package org.gzc.leetcode.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1797. 设计一个验证系统
 * @author GZC
 * @create 2023-02-09 19:43
 */
public class AuthenticationManager {
    Map<String, Integer> curCode;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        curCode = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        curCode.put(tokenId,currentTime+timeToLive);

    }

    public void renew(String tokenId, int currentTime) {
        //
        if (!curCode.containsKey(tokenId) || curCode.get(tokenId)<=currentTime){
            return;
        }
        curCode.put(tokenId,currentTime+timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans =0;
        Set<Map.Entry<String, Integer>> entries = curCode.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue()>currentTime){
                ans++;
            }
        }
        return ans;

    }
}
