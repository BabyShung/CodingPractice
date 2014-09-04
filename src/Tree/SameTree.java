package Tree;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * Recursive
 * 
 * Iterative
 * 
 * 
 * @author haozheng
 *
 */

public class SameTree {

	// iterative solution, using BFS, almost the same as BFS algo, just minor
	// difference
	public boolean isSameTreeIterative(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null || p.val != q.val)
			return false;

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();

		q1.add(p);
		q2.add(q);

		while (!q1.isEmpty() && !q2.isEmpty()) {

			TreeNode c1 = q1.poll();
			TreeNode c2 = q2.poll();

			// compare left node
			if (c1.left != null && c2.left != null
					&& c1.left.val == c2.left.val) {

				q1.add(c1.left);
				q2.add(c2.left);
			} else if (!(c1.left == null && c2.left == null)) {
				return false;
			}

			// compare right node
			if (c1.right != null && c2.right != null
					&& c1.right.val == c2.right.val) {

				q1.add(c1.right);
				q2.add(c2.right);
			} else if (!(c1.right == null && c2.right == null)) {
				return false;
			}

		}
		return q1.isEmpty() && q2.isEmpty();

	}

	// recursive solution, very straightforward
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if (p == null ^ q == null)
			return false;

		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

		return false;

	}

}
