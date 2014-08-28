package applications;

import helperClass.ListNode;
import helperClass.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Two solutions:
 * 
 * 
 * 
 * @author haozheng
 *
 */

public class ConvertSortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		// calculate list length --- O(n)
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		// build the BST
		return listToBST(head, 0, len - 1);
	}

	private TreeNode listToBST(ListNode head, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		// build up tree recursively
		TreeNode left = listToBST(head, low, mid - 1);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		// Java pass in Object by reference, so we can't change head but we can
		// change its content :)
		if (head.next != null) { // "move to next"
			head.val = head.next.val;
			head.next = head.next.next;
			root.right = listToBST(head, mid + 1, high);
		}
		return root;
	}
}
