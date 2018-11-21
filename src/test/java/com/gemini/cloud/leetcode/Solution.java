package com.gemini.cloud.leetcode;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] A) {

        Arrays.sort(A);

        if (A.length == 1) {
            return A[0];
        }

        for(int i = 0; i < A.length; i = i + 2) {

            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return 0;
    }
}