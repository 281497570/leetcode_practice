package org.lj.ds.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.slf4j.Slf4j;

/**
 * ValidParenthesesMain <br>
 * 20. Valid Parentheses <br>
 * https://leetcode.com/problems/valid-parentheses/description/ <br>
 */
@Slf4j
public class ValidParenthesesMain {

    public static void main(String[] args) {
        String str = "((([[{}]])))";
        log.info("{}", isValid(str));

    }

    public static boolean isValid(String str) {
        // 符号对
        final Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 栈
        final Deque<Character> stack = new LinkedBlockingDeque<>();

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) != stack.pollLast()) {
                    return false;
                }
            } else {
                stack.offerLast(c);
            }
        }

        return stack.isEmpty();
    }
}