import helperClass.BST;
import helperClass.TreeNode;
import Tree.BSTLeastCommonAncester;
import Tree.BSTSuccessor;
import Tree.SameTree;
import Tree.ValidateBinarySearchTree;
import applications.GrayCode;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// IntPalidrome ip = new IntPalidrome();
		// System.out.println(ip.isIntPalidrome(234323));
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(ip.reverse(-1000000013));
		//
		// Pow p = new Pow();
		// System.out.println("Pow: " + p.pow(1.00000, -2147483647));
		// System.out.println("Pow: " + p.pow2(1.00000, -2147483648));
		// System.out.println(Math.abs(-2147483647));
		// mergeArray ma = new mergeArray();
		// int[] a = { 3, 6, 7, 10 };
		// int[] b = { 1, 3, 5, 8, 9, 11 };
		// int[] r = ma.merge(a, b);
		//
		// SortedArrayIntersection sai = new SortedArrayIntersection();
		// int[] c = { 1, 4, 5 };
		// int[] d = { 1, 2, 3, 4, 5, 8, 9, 11 };
		// Set<Integer> ss = sai.getSortedArrayIntersection(c, d);
		// for (Integer tmp : ss)
		// System.out.print(tmp + " ");
		//
		// ValidNumber vn = new ValidNumber();
		// System.out.println(vn.isNumber("21344.1.23"));

		// strstr str = new strstr();
		// System.out.println("strstr matched: "
		// + str.strStr("baaakaaaaayaaaaaa", "aaaaaa"));

		// Sqrt sqrt = new Sqrt();
		// System.out.println("Sqrt: " + sqrt.sqrt(2));
		//
		// int[] sfararr = { 1, 7, 8, 8, 8, 8, 9, 11 };
		// SearchForARange sfar = new SearchForARange();
		// int[] sfarResult = sfar.searchRange(sfararr, 8);
		// System.out.println("[" + sfarResult[0] + "," + sfarResult[1] + "]");
		//
		//
		// SearchInsertPosition sip = new SearchInsertPosition();
		// System.out.println("SearchInsertPosition: "
		// +sip.searchInsert(sfararr, 8));
		//

		// UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
		// System.out.println(ubst.generateTrees(4).size());
		//
		// RemoveVowels rv = new RemoveVowels();
		// String str = "AbcdefIgikulO";
		// System.out.println("Recursive: "+rv.removeVowels(str));
		// System.out.println("Iterative: "+rv.removeVowelsIterative(str));

		// WordLadder wl = new WordLadder();
		// HashSet<String> dict = new HashSet<>();
		// dict.add("log");
		// dict.add("dog");
		// dict.add("hot");
		// dict.add("lot");
		// dict.add("dog");
		// System.out.println("WordLadder BFS: "
		// + wl.ladderLengthBFS("hit", "cog", dict));
		// System.out.println("WordLadder Dijkstra: "
		// + wl.ladderLengthDijkstra("hit", "cog", dict));
		//
		// LRU cache = new LRU(4);
		// System.out.println("inserted: " + cache.loadPage(2));
		// System.out.println("inserted: " + cache.loadPage(3));
		// System.out.println("inserted: " + cache.loadPage(1));
		// System.out.println("inserted: " + cache.loadPage(2));
		// System.out.println("inserted: " + cache.loadPage(4));
		// System.out.println("inserted: " + cache.loadPage(1));
		// System.out.println("inserted: " + cache.loadPage(4));
		// System.out.println("inserted: " + cache.loadPage(5));
		// System.out.println("inserted: " + cache.loadPage(6));
		//
		//
		// PlusOne po = new PlusOne();
		// int[] digits = {2,3,4,7};
		// int[] result = po.plusAnInteger(digits, 3249344);
		// System.out.println("plus an integer:");
		// for(int tmp: result){
		// System.out.print(tmp);
		// }
		// System.out.println();
		//
		//
		// FirstMissingPositive fmp = new FirstMissingPositive();
		// int[] fmparr = {-9,-3,-1,-5,3,6,2,1,5};
		// System.out.println("first missing positive: "+fmp.firstMissingPositive(fmparr));
		//
		//
		//
		GrayCode gc = new GrayCode();
		gc.grayCode(3);

		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();

		SameTree st = new SameTree();

		BSTSuccessor bsts = new BSTSuccessor();
		
		
		// Hao BST
		BST haoBST = new BST();
		haoBST.insert(5);
		haoBST.insert(3);
		haoBST.insert(7);
		haoBST.insert(4);
//		haoBST.insert(2);
//		haoBST.insert(6);
//		haoBST.insert(9);
//		haoBST.insert(15);
//		haoBST.insert(11);
//		haoBST.insert(13);

		BST haoBST2 = new BST();
		haoBST2.insert(5);
		haoBST2.insert(3);
		haoBST2.insert(7);
		haoBST2.insert(4);
		haoBST2.insert(2);
		haoBST2.insert(6);
		haoBST2.insert(9);
		haoBST2.insert(15);
		haoBST2.insert(11);
		haoBST2.insert(13);

		System.out.println(haoBST.getMaxNode());
		System.out.println(haoBST.getSecondMax());

		TreeNode root1 = haoBST.getRoot();
		TreeNode root2 = haoBST2.getRoot();

		System.out.println(vbst.isValidBSTIterative(root1));
		System.out.println(st.isSameTreeIterative(root1, root2));
		
		System.out.println("getSuccessorValue: "+bsts.getSuccessorValue(root1, 1));
		
		BSTLeastCommonAncester bstlca = new BSTLeastCommonAncester();
		System.out.println(bstlca.findLeastCommonAncester(root1, 3, 4));
		
	}

}
