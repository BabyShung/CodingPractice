package Tree;

import helperClass.TreeNode;

import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * 
 * Solution:
 * 
 * Modification of inorder traversal/ validateBST (stack implementation)
 * 
 * two cases (use the latter one to compare with the previous one):
 * 
 * ---1 3 2 4 5
 * 
 * ---1 4 2 3 5
 * 
 * 
 * @author haozheng
 *
 */

public class RecoverBST {
	public void recoverTree(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<>();

		TreeNode c = root, pre = null, first = null, second = null;
		while (!s.isEmpty() || c != null) {
			if (c != null) {
				s.push(c);
				c = c.left;
			} else {
				c = s.pop();
				if (pre != null && c.val < pre.val) {
					if (first == null) {
						first = pre;
						second = c;// assuming since you can't go back
					} else {
						second = c;
						break;
					}
				} else {
					pre = c;
				}
				pre = c;
				c = c.right;
			}
		}
		swap(first, second);
	}

	private void swap(TreeNode a, TreeNode b) {
		if (a == null || b == null)
			return;
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}
}
