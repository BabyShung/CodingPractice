package applications;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		// find the length of the list
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			++len;
			cur = cur.next;
		}

		if (len == 0 || k % len == 0)
			return head;
		k = k % len;

		ListNode pre = head;
		cur = head;
		// find the n-to-the-end
		while (cur.next != head) {
			if (k > 0) { // only forward end pointer
				--k;
			} else { // forward both pointers
				pre = pre.next;
			}
			cur = cur.next;
			// make it a circular linked list
			if (cur.next == null)
				cur.next = head;
		}

		ListNode newHead = pre.next;
		pre.next = null;

		return newHead;
	}
}
