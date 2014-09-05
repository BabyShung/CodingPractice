package applications;

import helperClass.ListNode;

public class RemoveDuplicateFromSortedList {
	
	//by Hao
	public ListNode deleteDuplicates(ListNode head) {

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
		s.next = f;//very important

		return head;

	}
}
