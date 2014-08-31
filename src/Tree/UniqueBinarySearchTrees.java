package Tree;

import helperClass.TreeNode;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {

	public ArrayList<TreeNode> generateTrees(int n) {
		return genSubTrees(1, n);
	}

	private ArrayList<TreeNode> genSubTrees(int l, int r) {
		
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		
		if (l > r) { // return an empty tree
			trees.add(null);
		} else {
			for (int i = l; i <= r; ++i) {
				
				ArrayList<TreeNode> lefts = genSubTrees(l, i - 1);
				ArrayList<TreeNode> rights = genSubTrees(i + 1, r);
				
				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						trees.add(root);
					}
				}
			}
		}
		return trees;
	}

}
