package applications;

import helperClass.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 * 
 * Really like Sophie's solution, originally I deal with it using recursion and
 * it is easy to make mistakes
 * 
 * 
 * @author haozheng
 *
 */

public class addTwoNumbers {
	public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		// both two lists not null

		int carry = 0;
		ListNode current = null, head = null;

		while (l1 != null || l2 != null) {

			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			// lazy init for first node
			if (current == null) {
				current = new ListNode(sum % 10);
				head = current;
			} else {
				current.next = new ListNode(sum % 10);
				current = current.next;
			}

			carry = sum / 10; // get the carry

		}

		// last case inspection
		if (carry > 0)
			current.next = new ListNode(carry);

		return head;

	}
}
