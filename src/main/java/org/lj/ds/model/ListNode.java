package org.lj.ds.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 链表节点
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
	public int data;
	public ListNode prev;
	public ListNode next;
}
