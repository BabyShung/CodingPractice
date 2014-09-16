package Merge_LinkedList_Array;

import helperClass.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * 
 * Solution 1: use an API: merger two sorted list function and do a logical
 * merge ---- O(nlogk) time and O(1) space
 * 
 * Solution 2: use a min heap ---- O(nlogk) time and O(k) or O(1) space
 * 
 * First build min heap based on the k first heads, then remove top and add to
 * the final list. Then add this removed node's next node into the heap O(logk),
 * and keep on doing this until the heap is empty. Since there are n elements,
 * no need to think about build heap O(k) and remove O(1), n with logk
 * insertion, so the final is the O(nlogk) time
 * 
 * 
 * 
 * 
 * @author haozheng
 *
 */

public class MergeKSortedList {

	//priority queue
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.isEmpty())
			return null;

		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val < n2.val)
					return -1;
				if (n1.val > n2.val)
					return 1;
				return 0;
			}
		};

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), comparator);
		for (ListNode node : lists) { // the first node
			if (node != null)
				heap.add(node);// O(logK)
		}

		ListNode head = null, cur = null;
		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				cur = head;
			} else {
				cur.next = heap.poll();
				cur = cur.next;
			}
			if (cur.next != null)// add the removed one's next to the heap
				heap.add(cur.next);
		}

		return head;
	}

	// solution 2
	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists.isEmpty())
			return null;

		int last = lists.size() - 1;

		int current = 0;

		while (last > 0) {
			current = 0;

			while (current < last) {
				lists.set(current,
						mergeTwoLists(lists.get(current++), lists.get(last--)));
			}
		}
		return lists.get(0);

	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode fake = new ListNode(0);
		ListNode cursor = fake;
		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				cursor.next = l1;
				l1 = l1.next;
			} else {
				cursor.next = l2;
				l2 = l2.next;
			}
			cursor = cursor.next;
		}

		if (l1 == null)
			cursor.next = l2;
		else
			cursor.next = l1;

		return fake.next;
	}
}
