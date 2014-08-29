package Tree;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * Both iterative and recursive
 * 
 * @author haozheng
 *
 */

public class isSymmetric {

	// iterative
	public boolean isSymmetricIterative(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null)
			return true;
		else if (root.left == null || root.right == null
				|| root.left.val != root.right.val) {
			return false;
		}

		// both not null

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();

		q1.add(root.left);
		q2.add(root.right);

		while (!q1.isEmpty() && !q2.isEmpty()) {

			TreeNode c1 = q1.poll();
			TreeNode c2 = q2.poll();

			if (c1.left != null && c2.right != null
					&& c1.left.val == c2.right.val) {
				q1.add(c1.left);
				q2.add(c2.right);
			} else if (!(c1.left == null && c2.right == null)) {
				return false;
			}

			if (c1.right != null && c2.left != null
					&& c1.right.val == c2.left.val) {
				q1.add(c1.right);
				q2.add(c2.left);
			} else if (!(c1.right == null && c2.left == null)) {
				return false;
			}
		}
		return q1.isEmpty() && q2.isEmpty();
	}

	// recursive
	public boolean isSymmetricTree(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricRec(root.left, root.right);

	}

	private boolean isSymmetricRec(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else if (left == null || right == null || left.val != right.val)
			return false;
		else
			return isSymmetricRec(left.left, right.right)
					&& isSymmetricRec(left.right, right.left);
	}
}
