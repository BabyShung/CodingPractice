package Tree;

import helperClass.TreeNode;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author haozheng
 *
 */

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> s = new Stack<>();// dfs traversal
		Stack<Integer> p = new Stack<>();// keep track of last prefix
		
		int sum = 0, preN = 0;
		
		s.push(root);// push root
		p.push(preN);// push 0

		while (!s.isEmpty()) {
			TreeNode c = s.pop();
			preN = p.pop();// important, every time pop the last prefix
			preN = preN * 10 + c.val;// calculate the current path value

			if (c.left == null && c.right == null) {// reach leaf node
				sum = sum + preN; // sum up and continue
				continue;
			}

			if (c.left != null)
				s.push(c.left);
			if (c.right != null)
				s.push(c.right);

			if (c.left != null && c.right != null)// if the current node has two
													// children, push twice
													// prefix since it will come
													// back
				p.push(preN);
			p.push(preN);
		}
		return sum;

	}

	public int sumNumbersSophie(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbersHelper(root, root.val, 0);
	}

	private int sumNumbersHelper(TreeNode root, int path, int sum) {
		if (root.left == null && root.right == null) { // reach a leaf
			return sum + path;
		}

		if (root.left != null) { // go to left subtree
			sum = sumNumbersHelper(root.left, path * 10 + root.left.val, sum);
		}
		if (root.right != null) { // go to right subtree
			sum = sumNumbersHelper(root.right, path * 10 + root.right.val, sum);
		}

		return sum;
	}
}
