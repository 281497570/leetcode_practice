package org.lj.ds.stack;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * QueueAsStack <br>
 * 225. Implement Stack using Queues <br>
 * https://leetcode.com/problems/implement-stack-using-queues/submissions/ <br>
 */
@Slf4j
public class QueueAsStackMain {
    public static void main(String[] args) {

        QueueStack stack = new QueueStack();
        // for (int i = 0; i < 5; i++) {
        // stack.push(i + 1);
        // }

        // for (int i = 0; i < 5; i++) {
        // if (new Random().nextInt(10) % 2 == 0) {
        // log.info("top:{}", stack.top());
        // } else {
        // log.info("pop:{}", stack.pop());
        // }
        // }

        // while (!stack.empty()) {
        // log.info("pop:{}", stack.pop());
        // }

        // log.info("isEmpty:{}", stack.empty());

        stack.push(1);
        stack.push(2);
        log.info("{}", stack.top()); // returns 2
        log.info("{}", stack.pop()); // returns 2
        log.info("{}", stack.empty()); // returns false
    }

    /**
     * 用Queue实现的Stack
     */
    static class QueueStack {
        private static final int EMPTY = -1;

        private final Queue<Integer> queue = new LinkedBlockingQueue<>();
        private final Queue<Integer> tempQueue = new LinkedBlockingQueue<>();

        private int top = EMPTY;

        // O(1)
        public void push(int data) {
            queue.offer(data);
        }

        // O(N)
        public int pop() {
            int result = top();
            top = EMPTY;
            return result;
        }

        // O(N)
        public int top() {
            if (top != EMPTY) {
                return top;
            }
            if (queue.isEmpty()) {
                top = EMPTY;
            } else if (queue.size() == 1) {
                top = queue.poll();
            } else {
                // 将主队列中除最后一个之外的所有元素弹到辅助队列中
                while (queue.size() > 1) {
                    tempQueue.offer(queue.poll());
                }
                // 再把元素从辅助队列弹到主队列中
                while (!tempQueue.isEmpty()) {
                    queue.offer(tempQueue.poll());
                }
                top = queue.poll();
            }
            return top;
        }

        // O(1)
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
