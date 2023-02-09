package org.gzc.leetcode;

import org.gzc.leetcode.model.AuthenticationManager;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202302 {


    /**
     * 802. 迷路的机器人
     */

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1797:
                AuthenticationManager authenticationManager = new AuthenticationManager(10);
                authenticationManager.generate("aaa",10);
                authenticationManager.renew("bbb",12);
                System.out.println(authenticationManager.countUnexpiredTokens(12));
                break;
            case 1604:
                System.out.println(alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
                break;
            case 1233:
                System.out.println(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
            default:
                break;
        }
    }

    /**
     * 1233. 删除子文件夹
     */
    public static List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        for (String s : folder) {

            boolean flag = true;
            for (String an : ans) {
                if (s.startsWith(an) && '/' == s.charAt(an.length())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(s);
            }
        }
        return ans;
    }

    /**
     * 1604. 警告一小时内使用相同员工卡大于等于三次的人
     */
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> mapSet = new HashMap<>(10);
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            if (mapSet.containsKey(keyName[i])) {
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                mapSet.get(keyName[i]).add(hour * 60 + min);
            } else {
                List<Integer> treeSet = new ArrayList<>();
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                treeSet.add(hour * 60 + min);
                mapSet.put(keyName[i], treeSet);
            }
        }
        Set<Map.Entry<String, List<Integer>>> entries1 = mapSet.entrySet();
        for (Map.Entry<String, List<Integer>> stringListEntry : entries1) {
            List<Integer> value = stringListEntry.getValue();
            int size = value.size();
            if (size < 3) {
                continue;
            }
            value.sort(Integer::compareTo);
            int left = 0;
            int right = 0;
            while (right < size) {
                if (value.get(right) - value.get(left) <= 60) {
                    right++;
                } else {
                    left++;
                }
                if (right - left >= 3) {
                    String key = stringListEntry.getKey();
                    ans.add(key);
                    break;
                }
            }


        }
        ans.sort(String::compareTo);
        return ans;
    }


}
