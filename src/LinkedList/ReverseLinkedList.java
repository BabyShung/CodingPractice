package LinkedList;

import helperClass.ListNode;

/**
 * reverse a linkedList
 * 
 * 
 * 
 * @author haozheng
 *
 */

public class ReverseLinkedList {
	public ListNode reverseLinkedList(ListNode head) {

		ListNode pre = null, cur = head;

		while (cur != null) {
			ListNode nn = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nn;
		}
		return pre;
	}
}
