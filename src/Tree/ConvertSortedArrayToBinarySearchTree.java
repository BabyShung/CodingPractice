package Tree;

import helperClass.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * Solution: the trick is to set middle element of the array to be root, and
 * recursively apply other nodes
 * 
 * 
 * Running time: T(n) = 2T(n/2) + O(1) = O(n).
 * 
 * @author haozheng
 *
 */

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {

		return buildBST(num, 0, num.length - 1);
	}

	public TreeNode buildBST(int[] arr, int f, int r) {

		if (f > r)
			return null;

		int m = (f + r) / 2;
		TreeNode node = new TreeNode(arr[m]);

		node.left = buildBST(arr, f, m - 1);
		node.right = buildBST(arr, m + 1, r);

		return node;
	}
}
