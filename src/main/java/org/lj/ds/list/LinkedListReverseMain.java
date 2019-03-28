package org.lj.ds.list;

import org.lj.ds.model.ListNode;

/**
 * 单链表反转 <br>
 * 206. Reverse Linked List <br>
 * https://leetcode.com/problems/reverse-linked-list/ <br>
 */
public class LinkedListReverseMain {
	static final int N = 5;

	/**
	 * 反转单链表 思路： <br>
	 * 1. 用一个prev指针保存当前节点（prev初始为null） <br>
	 * 2. 遍历所有节点，每个节点的next变更为prev <br>
	 * 3. 最后返回prev
	 */
	public static ListNode reverseLinkedList(final ListNode head) {
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			// 记录原next
			ListNode next = curr.next;

			// 将当前节点的next指向前驱
			curr.next = prev;

			// 更新prev
			prev = curr;

			// 用next继续遍历
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode[] nodes = ListUtil.createSinleLinkedList(5);
		ListUtil.tranverse(nodes[0]);

		ListNode newHead = reverseLinkedList(nodes[0]);
		ListUtil.tranverse(newHead);
	}
}