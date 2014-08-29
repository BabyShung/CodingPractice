package Tree;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * simple BFS
 * 
 * @author haozheng
 *
 */

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		int md = 0;

		while (!q.isEmpty()) {

			TreeNode c = q.poll();

			if (c == null) {// a level ends

				if (!q.isEmpty()) {
					q.add(null);
					md++;
				}

			} else {

				if (c.left == null && c.right == null) {
					// shortest ones,return the depth number
					return ++md;
				}

				if (c.left != null)
					q.add(c.left);
				if (c.right != null)
					q.add(c.right);

			}

		}

		return md;
	}
}
