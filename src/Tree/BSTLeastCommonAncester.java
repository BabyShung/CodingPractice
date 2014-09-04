package Tree;

import helperClass.TreeNode;

public class BSTLeastCommonAncester {

	public TreeNode findLeastCommonAncester(TreeNode node, int v1, int v2) {

		while (node != null) {
			if (node.val > v1 && node.val > v2)
				node = node.left;
			else if (node.val < v1 && node.val < v2)
				node = node.right;
			else
				return node;
		}

		return null;
	}

}
