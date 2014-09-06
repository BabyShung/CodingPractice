package Tree;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> r = new ArrayList<>();

		if (root == null)
			return r;

		boolean oddlevel = false; // even: 0,2,4

		Stack<TreeNode> s = new Stack<>();

		s.add(root);

		while (!s.isEmpty()) {

			List<Integer> level = new ArrayList<>();
			Stack<TreeNode> sTmp = new Stack<>();

			while (!s.isEmpty()) {

				TreeNode c = s.pop();

				if (!oddlevel) {
					if (c.left != null)
						sTmp.push(c.left);
					if (c.right != null)
						sTmp.push(c.right);
				} else {
					if (c.right != null)
						sTmp.push(c.right);
					if (c.left != null)
						sTmp.push(c.left);
				}

				level.add(c.val);

			}
			r.add(level);
			oddlevel = !oddlevel;
			s = sTmp;
		}
		return r;

	}
}
