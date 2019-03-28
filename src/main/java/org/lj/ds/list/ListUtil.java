package org.lj.ds.list;

import org.lj.ds.model.ListNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表工具类
 */
@Slf4j
public class ListUtil {
    private ListUtil() {
    }

    public static ListNode[] createSinleLinkedList(final int N) {
        ListNode[] nodes = new ListNode[N];
        for (int i = 0; i < N; ++i) {
            nodes[i] = new ListNode(i + 1, null, null);
        }

        for (int i = 0; i < N - 1; ++i) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes;
    }

    /**
     * 遍历链表
     */
    public static void tranverse(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }
        sb.append("]");
        log.info("{}", sb.toString());
    }

}