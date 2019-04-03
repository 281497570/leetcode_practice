package org.lj.ds.stack;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.slf4j.Slf4j;

/**
 * MinStack <br>
 * 155. Min Stack <br>
 * https://leetcode.com/problems/min-stack/ <br>
 */
@Slf4j
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(7);
        log.info("{}", minStack.getMin());
        minStack.push(2);
        log.info("{}", minStack.getMin());
        minStack.push(6);
        log.info("{}", minStack.getMin());
        minStack.push(1);
        log.info("{}", minStack.getMin());
        minStack.push(3);
        log.info("{}", minStack.getMin());
        minStack.push(5);
        log.info("{}", minStack.getMin());

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        log.info("{}", minStack.top()); // --> Returns 0.
        log.info("{}", minStack.getMin()); // --> Returns -2.
    }

    private final Deque<Integer> stack = new LinkedBlockingDeque<>();
    private final Deque<Integer> minStack = new LinkedBlockingDeque<>();

    public MinStack() {
    }

    public void push(int x) {
        Integer min = minStack.peekLast();
        if (min == null) {
            minStack.offerLast(x);
        } else {
            minStack.offerLast(Math.min(x, min));
        }
        stack.offerLast(x);
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
