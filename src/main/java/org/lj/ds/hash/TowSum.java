package org.lj.ds.hash;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * TowSum <br>
 * 1. Two Sum <br>
 * https://leetcode.com/problems/two-sum/ <br>
 */
@Slf4j
public class TowSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] results = new TowSum().twoSum(nums, target);
        log.info("results:{}", results);
    }

    /**
     * O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = map.getOrDefault(target - nums[i], -1);
            if (res >= 0) {
                return new int[] { res, i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
