package Merge_LinkedList_Array;

import helperClass.ListNode;

public class MergeTwoSortedLists {
	// passed leetcode
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode fake = new ListNode(520);
		ListNode cur = fake;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if (l1 == null)
			cur.next = l2;
		else
			cur.next = l1;

		return fake.next;
	}
}
