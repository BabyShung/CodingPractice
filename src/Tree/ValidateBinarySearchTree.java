package Tree;

import helperClass.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return validBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean validBSTRecur(TreeNode root, int low, int high) {
		if (root == null)
			return true;
		if (root.val < low || root.val > high)
			return false;
		return (validBSTRecur(root.left, low, root.val - 1) && validBSTRecur(
				root.right, root.val + 1, high));
	}

	// iterative solution, just traverse and check
	public boolean isValidBSTIterative(TreeNode root) {

		if (root == null)
			return true;

		Stack<TreeNode> s = new Stack<>();

		TreeNode c = root, parent = null;

		while (!s.isEmpty() || c != null) {

			if (c != null) {

				s.push(c);
				c = c.left;
			} else {

				c = s.pop();

				if (parent != null && c.val <= parent.val) {
					return false;

				}
				parent = c;
				c = c.right;
			}
		}

		return true;
	}
}
