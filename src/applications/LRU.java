package applications;

import java.util.HashMap;

public class LRU {
	private int capacity = 0;
	private int maxCapacity = 10;
	private DListNode head = null;
	private DListNode tail = null;
	private HashMap<Integer, DListNode> map = new HashMap<Integer, DListNode>();

	public LRU(final int limit) {
		if (limit < 1) {
			throw new Error("Max capacity must be positive.");
		}
		maxCapacity = limit;
	}

	public int loadPage(final int page) {// page number, ------ O(1)
		final DListNode cur;

		if (map.containsKey(page)) { // cache hit
			cur = map.get(page);
			if (cur != head) {// if exists, remove the old one first and add new
								// one to head
				remove(cur);//O(1)
				insertToHead(cur);//O(1)
			}
			print();
			return cur.val;
		}

		// cache miss, not exist in the buffer
		cur = new DListNode(page);
		insertToHead(cur);
		map.put(page, cur);

		if (capacity == maxCapacity) {
			removeTail();
		} else {
			++capacity;
		}
		print();

		return cur.val;
	}

	/** Remove the given node from the linked list. */
	private void remove(final DListNode cur) {
		if (cur.pre != null)
			cur.pre.next = cur.next;
		if (cur.next != null)
			cur.next.pre = cur.pre;
		if (tail == cur)
			tail = cur.pre;
	}

	/** Remove the tail of the linked list and return the deleted node. */
	private DListNode removeTail() {
		map.remove(tail.val);
		DListNode last = tail;
		tail = tail.pre;
		tail.next = null;
		if (head == last)
			head = null;
		return last;
	}

	/** Add the given node to the head of the linked list. */
	private void insertToHead(final DListNode cur) {
		cur.next = head;
		cur.pre = null;
		if (head != null)
			head.pre = cur;
		head = cur;
		if (tail == null)
			tail = cur;
	}

	private void print() {
		DListNode cur = head;
		System.out.print("(head) ");
		while (cur != null) {
			System.out.print(cur.val);
			if (cur == tail)
				System.out.print(" (tail)");
			else
				System.out.print("->");
			cur = cur.next;
		}
		System.out.println("");
	}

	/** Doubly Linked list */
	private class DListNode {
		DListNode pre = null;
		DListNode next = null;
		int val;

		DListNode(int v) {
			val = v;
		}
	}
}
