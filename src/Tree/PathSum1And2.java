package Tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 */

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum1And2 {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) // get to a leaf
			return (sum == root.val);
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val); // still like dfs
	}

	public boolean hasPathSumByHao(TreeNode root, int sum) {
		if (root == null)
			return false;

		Stack<TreeNode> s = new Stack<>();
		Stack<Integer> p = new Stack<>();

		s.push(root);
		p.push(0);

		while (!s.isEmpty()) {

			TreeNode c = s.pop();
			int pre = p.pop() + c.val;

			if (c.left == null && c.right == null) {// reach leaf node
				if (sum == pre)
					return true;
				else
					continue;
			}

			if (c.left != null)
				s.push(c.left);
			if (c.right != null)
				s.push(c.right);

			if (c.left != null && c.right != null)
				p.push(pre);
			p.push(pre);

		}
		return false;
	}

	/**
	 * output paths
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		findPathSum(root, sum, tmp, r);
		return r;
	}

	private void findPathSum(TreeNode root, int sum, List<Integer> tmp,
			List<List<Integer>> r) {
		if (root == null)
			return;
		//***** take a careful look, it is preOrder, DFS
		tmp.add(root.val);
		if (root.left == null && root.right == null) { // leaf
			if (sum == root.val) { // found a path
				r.add(new ArrayList<Integer>(tmp));
			}
		}
		findPathSum(root.left, sum - root.val, tmp, r);
		findPathSum(root.right, sum - root.val, tmp, r);
		tmp.remove(tmp.size() - 1);
	}

}
