package applications;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Classic problem, should understand time and space complexity O(n) time and
 * space
 * 
 * @author haozheng
 *
 */

public class MaximumDepthOfBinaryTree {
	// iterative solution
	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<>();

		int len = 0;
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			TreeNode cur = q.poll();

			if (cur == null) {
				// a level ends

				if (q.isEmpty()) {
					return ++len;
				} else {
					q.add(null);
					len++;
				}
			} else {
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}

		}

		return len;
	}

	// recursive solution
	public int maxDepthR(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + Math.max(maxDepthR(root.left), maxDepthR(root.right));

	}
}
