package Tree;

/**
 * binary tree level traversal
 * 
 * 
 */

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		// root not null
		TreeNode cur = null;
		q.add(root);
		q.add(null);
		List<Integer> level = new ArrayList<>();

		while (!q.isEmpty()) {
			cur = q.poll();

			if (cur == null) {// end of a level
				result.add(level);
				if (q.isEmpty())
					return result;
				else { // not end of a tree, so just add null for next level
					q.add(null);
					level = new ArrayList<>();
				}
			} else {
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
				level.add(cur.val);
			}
		}
		return null;
	}
}
