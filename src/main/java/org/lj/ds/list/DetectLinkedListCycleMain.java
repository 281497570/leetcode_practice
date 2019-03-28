package org.lj.ds.list;

import java.util.HashSet;
import java.util.Set;

import org.lj.ds.model.ListNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 检测链表是否有环
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
@Slf4j
public class DetectLinkedListCycleMain {
    public static void main(String[] args) {
        // 创建回环链表
        ListNode[] nodes = ListUtil.createSinleLinkedList(5);
        // nodes[nodes.length - 1].next = nodes[3];

        // 暴力检测
        boolean isCycleWithLimitDepth = isCycleWithLimitDepth(nodes[0], nodes.length);
        log.info("isCycleWithLimitDepth:{}", isCycleWithLimitDepth);

        boolean isCycleWithMarked = isCycleWithMarked(nodes[0]);
        log.info("isCycleWithMarked:{}", isCycleWithMarked);

        boolean isCycleWithFastAndSlowPoint = isCycleWithFastAndSlowPoint(nodes[0]);
        log.info("isCycleWithFastAndSlowPoint:{}", isCycleWithFastAndSlowPoint);

    }

    /**
     * 暴力检测，判断迭代次数是否大于链表长度或最大次数限制 <br>
     * 时间复杂度：O(N) <br>
     * 
     * @param depth
     */
    private static boolean isCycleWithLimitDepth(ListNode head, int depth) {
        int i = 0;
        ListNode node = head;
        while (node != null) {
            if (i > depth) {
                return true;
            }
            node = node.next;
            i++;
        }

        return false;
    }

    /**
     * 标记节点是否被访问过 时间复杂度：O(N) <br>
     * 空间复杂度：O(N) <br>
     */
    private static boolean isCycleWithMarked(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (!visited.add(node)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    /**
     * 用快慢指针，快指针每次走两步，慢指针每次走一步，如果是环必定会相遇 时间复杂度：O(N) <br>
     */
    private static boolean isCycleWithFastAndSlowPoint(ListNode head) {
        ListNode fast = head, slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast == null ? null : fast.next == null ? null : fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}