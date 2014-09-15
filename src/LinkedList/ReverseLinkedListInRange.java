package LinkedList;

import helperClass.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL
 * 
 * Note: Given m, n satisfy the following condition: 1 <= m <= n <= length of
 * list.
 * 
 * @author haozheng
 *
 */

public class ReverseLinkedListInRange {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode fake = new ListNode(520);
		fake.next = head;
		ListNode pre = fake, cur = head;
		int p = 1;

		while (p < m && cur != null) {
			cur = cur.next;
			pre = pre.next;
			p++;
		}

		while (p < n && cur != null) {
			ListNode nn = cur.next.next;
			cur.next.next = pre.next;
			pre.next = cur.next;
			cur.next = nn;
			p++;
		}
		return fake.next;
	}
}
