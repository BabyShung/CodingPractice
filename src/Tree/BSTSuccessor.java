package Tree;

import helperClass.TreeNode;

import java.util.Stack;

public class BSTSuccessor {

	public int getSuccessorValue(TreeNode root, int value) {

		if (root == null)
			return Integer.MIN_VALUE;

		Stack<TreeNode> s = new Stack<>();

		TreeNode c = root;

		while (!s.isEmpty() || c != null) {

			if (c != null) {
				s.push(c);
				c = c.left;
			} else {
				c = s.pop();

				if (c.val > value)
					return c.val;

				c = c.right;
			}
		}
		return -1;
	}
}
