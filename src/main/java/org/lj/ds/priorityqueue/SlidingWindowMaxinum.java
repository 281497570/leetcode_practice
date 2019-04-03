package org.lj.ds.priorityqueue;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.slf4j.Slf4j;

/**
 * SlidingWindowMax <br>
 * 239. Sliding Window Maximum <br>
 * https://leetcode.com/problems/sliding-window-maximum/
 */
@Slf4j
public class SlidingWindowMaxinum {

    public static void main(String[] args) {
        // final int[] nums = new int[] { 1, 3, 1, 2, 0, 5 };
        // final int k = 3;
        // final int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        // final int k = 3;

        final int[] nums = new int[] { 1, -1 };
        final int k = 1;

        SlidingWindowMaxinum slidingWindow = new SlidingWindowMaxinum();
        int[] result1 = slidingWindow.maxSlidingWindow2(nums, k);
        log.info("{}", result1);
        int[] result2 = slidingWindow.maxSlidingWindow(nums, k);
        log.info("{}", result2);
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        // nums is empty
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // nums.length less than k
        if (nums.length - k < 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[] { max };
        }

        // nums.length more than k
        int max;
        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i < results.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            results[i] = max;
        }
        return results;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // nums is empty
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // nums.length less than k
        if (nums.length - k < 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[] { max };
        }

        // store the elem index
        Deque<Integer> window = new LinkedBlockingDeque<>();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // i >= k：表示窗口已满，需要弹出队首元素
            // window.peek() < i - k：窗口第一个元素生命周期已到
            if (i >= k && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            // 如果队尾元素小于等于要被加入的元素，则将其弹出
            // 因为小的元素没有必要存在与队列中
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }

            // 将当前元素入队
            window.offerLast(i);

            if (i >= k - 1) {
                // 窗口已满，满足对比条件
                result[i - k + 1] = nums[window.peekFirst()];
            }
        }

        return result;
    }
}
