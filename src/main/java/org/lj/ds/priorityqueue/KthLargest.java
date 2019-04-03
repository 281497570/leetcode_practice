package org.lj.ds.priorityqueue;

import java.util.PriorityQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * Kth Largest <br>
 * 703. Kth Largest Element in a Stream <br>
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/ <br>
 */
@Slf4j
public class KthLargest {
    public static void main(String[] args) {
        final int K = 3;
        // KthLargest kthLargest = new KthLargest(K, new int[] { 4, 5, 8, 2 });
        KthLargest kthLargest = new KthLargest(K, new int[] {});
        log.info("{}", kthLargest.add(3)); // returns 4
        log.info("{}", kthLargest.add(5)); // returns 5
        log.info("{}", kthLargest.add(10)); // returns 5
        log.info("{}", kthLargest.add(9)); // returns 8
        log.info("{}", kthLargest.add(4)); // returns 8
    }

    private int size;
    private final int k;
    private final PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            add0(nums[i]);
        }
    }

    public int add(int val) {
        add0(val);
        return queue.peek();
    }

    private void add0(int val) {
        if (size >= k) {
            if (val > queue.peek()) {
                size++;
                queue.poll();
                queue.offer(val);
            }
        } else {
            size++;
            queue.offer(val);
        }
    }
}
