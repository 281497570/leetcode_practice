package org.lj.ds.queue;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.slf4j.Slf4j;

/**
 * StackAsQueue <br>
 * 232. Implement Queue using Stacks <br>
 * https://leetcode.com/problems/implement-queue-using-stacks/ <br>
 */
@Slf4j
public class StackAsQueue {

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            log.info("{}", queue.pop());
        }

        for (int i = 0; i < 2; i++) {
            log.info("{}", queue.peek());
        }

        for (int i = 5; i < 10; i++) {
            queue.push(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            log.info("{}", queue.pop());
        }
        log.info("isEmpty:{}", queue.empty());
    }

    static class StackQueue {
        // 用java的deque模拟stack offerLast==push pollLast==pop
        private final Deque<Integer> inStack = new LinkedBlockingDeque<>();
        private final Deque<Integer> outStack = new LinkedBlockingDeque<>();

        // O(1)
        public void push(int data) {
            inStack.offerLast(data);
        }

        // O(N)
        public int pop() {
            int result = peek();
            if (result != -1) {
                outStack.pollLast();
            }
            return result;
        }

        // O(N)
        public int peek() {
            if (outStack.isEmpty()) {
                // 将数据从inStack中弹到outStack，数据在outStack中就是FILO的顺序了
                while (!inStack.isEmpty()) {
                    outStack.offerLast(inStack.pollLast());
                }
            }
            return outStack.isEmpty() ? -1 : outStack.peekLast();
        }

        // O(1)
        public boolean empty() {
            return outStack.isEmpty() && inStack.isEmpty();
        }
    }
}
