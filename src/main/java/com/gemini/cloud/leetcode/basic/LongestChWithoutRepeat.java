package com.gemini.cloud.leetcode.basic;

import java.util.*;

public class LongestChWithoutRepeat {


    /**
     * Sliding Window Optimized
     */
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }

    /**
     *  map
     */
    public static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }

    /**
     * ASCII
     */
    public static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }


    /**
     * My solution
     * @param s
     * @return
     */
    public static int getSubString(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        Set<Character> characters = new HashSet<>();
        String tmp = "";

        int max = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (characters.add(s.charAt(i))) {
                tmp = tmp.concat(String.valueOf(s.charAt(i)));
                if (i == s.length()-1 && tmp.length() >= max) {
                    return tmp.length();
                }
                continue;
            } else {
                if(tmp.length() > max) {
                    max = tmp.length();
                }
                //发现重复，结束，指针回到重复的字符位置
                i = i - tmp.length() + tmp.indexOf(String.valueOf(s.charAt(i)));
                tmp = "";
                characters.clear();
            }
        }


        return max;

    }


    public static void main(String[] args) {

        String string = "aabccsawasdeweweq";

        // 1st
        System.out.println(getSubString(string));

        // 2nd
        System.out.println(new LongestChWithoutRepeat.Solution().lengthOfLongestSubstring(string));

        // 3rd
        System.out.println(new LongestChWithoutRepeat.Solution().lengthOfLongestSubstring(string));

        // 4th
        System.out.println(new LongestChWithoutRepeat.Solution().lengthOfLongestSubstring(string));



    }
}
