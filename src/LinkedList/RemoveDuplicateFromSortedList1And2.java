package LinkedList;

import helperClass.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author haozheng
 *
 */

public class RemoveDuplicateFromSortedList1And2 {

	// simpliest
	public ListNode deleteDuplicates(ListNode head) {
		ListNode c = head;
		while (c != null && c.next != null) {
			if (c.val == c.next.val) {
				c.next = c.next.next;
			} else {
				c = c.next;
			}
		}
		return head;
	}

	// by Hao
	public ListNode deleteDuplicates2(ListNode head) {

		if (head == null)
			return head;

		ListNode f = head.next, s = head;

		while (f != null) {

			if (s.val == f.val) {
				f = f.next;
			} else {
				s.next = f;// get rid of the duplicated elements
				s = f;// restart
				f = s.next;
			}

		}
		s.next = f;// very important

		return head;

	}

	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
	 * 1->1->1->2->3, return 2->3.
	 * 
	 */
	public ListNode deleteDuplicatesII(ListNode head) {

		ListNode fake = new ListNode(520);
		fake.next = head;
		ListNode c = head, last = fake;

		while (c != null && c.next != null) {
			if (c.val == c.next.val) {
				while (c.next != null && c.val == c.next.val)
					c = c.next;
				last.next = c.next;
				c = last.next;
			} else {
				last = c;
				c = c.next;
			}
		}
		return fake.next;

	}
}
