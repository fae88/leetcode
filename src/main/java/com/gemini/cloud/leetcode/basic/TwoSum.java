package com.gemini.cloud.leetcode.basic;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 15,2, 7, 11, 88};


        // 1st method
//        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(new TwoTreesEquals().twoSum(nums, 9)));
//        System.out.println(System.currentTimeMillis() - start);

        // 2nd method
        long start = System.nanoTime();
        System.out.println(Arrays.toString(new Solution2().twoSum(nums, 90)));
        System.out.println(System.nanoTime() - start);

    }


    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            List<Integer> list = new ArrayList<Integer>();
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i ++) {

                int post = target - nums[i];

                if(list.contains(post) && list.indexOf(post) != i) {
                    result[0] = list.indexOf(post);
                    result[1] = i;
                    return result;
                }
                list.add(nums[i]);
            }

            throw new IllegalArgumentException("cannot find tow nums");
        }
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}


