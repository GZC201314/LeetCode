package org.gzc.leetcode.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 676. 实现一个魔法字典
 */
public class MagicDictionary {
    Map<Integer, HashSet<String>> dict;

    /**
     * 初始化字典树
     */
    public MagicDictionary() {
        dict = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String key : dictionary) {
            int length = key.length();
            HashSet<String> dictSet = dict.get(length);
            if(dictSet == null){
                dictSet = new HashSet<>();
            }
            dictSet.add(key);
            dict.put(length, dictSet);
        }

    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        HashSet<String> dictSet = dict.get(length);
        if(dictSet == null){
            return false;
        }
        int diff =0;
        for (String key : dictSet) {
            diff =0;
            for(int i=0;i<length;i++){
                if(key.charAt(i) != searchWord.charAt(i)){
                    diff++;
                }
            }
            if(diff == 1){
                break;
            }
        }
        return diff ==1;
    }
}
