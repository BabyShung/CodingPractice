import java.util.HashSet;
import java.util.Set;

import applications.FirstMissingPositive;
import applications.GrayCode;
import applications.IntPalidrome;
import applications.LRU;
import applications.PlusOne;
import applications.Pow;
import applications.SortedArrayIntersection;
import applications.ValidNumber;
import applications.WordLadder;
import applications.mergeArray;
import applications.strstr;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		IntPalidrome ip = new IntPalidrome();
//		System.out.println(ip.isIntPalidrome(234323));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(ip.reverse(-1000000013));
//
//		Pow p = new Pow();
//		System.out.println("Pow: " + p.pow(1.00000, -2147483647));
//		System.out.println("Pow: " + p.pow2(1.00000, -2147483648));
//		System.out.println(Math.abs(-2147483647));
//		mergeArray ma = new mergeArray();
//		int[] a = { 3, 6, 7, 10 };
//		int[] b = { 1, 3, 5, 8, 9, 11 };
//		int[] r = ma.merge(a, b);
//
//		SortedArrayIntersection sai = new SortedArrayIntersection();
//		int[] c = { 1, 4, 5 };
//		int[] d = { 1, 2, 3, 4, 5, 8, 9, 11 };
//		Set<Integer> ss = sai.getSortedArrayIntersection(c, d);
//		for (Integer tmp : ss)
//			System.out.print(tmp + " ");
//
//		ValidNumber vn = new ValidNumber();
//		System.out.println(vn.isNumber("21344.1.23"));

		strstr str = new strstr();
		System.out.println("strstr matched: "
				+ str.strStr("baaakaaaaayaaaaaa", "aaaaaa"));

//		WordLadder wl = new WordLadder();
//		HashSet<String> dict = new HashSet<>();
//		dict.add("log");
//		dict.add("dog");
//		dict.add("hot");
//		dict.add("lot");
//		dict.add("dog");
//		System.out.println("WordLadder BFS: "
//				+ wl.ladderLengthBFS("hit", "cog", dict));
//		System.out.println("WordLadder Dijkstra: "
//				+ wl.ladderLengthDijkstra("hit", "cog", dict));
//
//		LRU cache = new LRU(4);
//		System.out.println("inserted: " + cache.loadPage(2));
//		System.out.println("inserted: " + cache.loadPage(3));
//		System.out.println("inserted: " + cache.loadPage(1));
//		System.out.println("inserted: " + cache.loadPage(2));
//		System.out.println("inserted: " + cache.loadPage(4));
//		System.out.println("inserted: " + cache.loadPage(1));
//		System.out.println("inserted: " + cache.loadPage(4));
//		System.out.println("inserted: " + cache.loadPage(5));
//		System.out.println("inserted: " + cache.loadPage(6));
//
//		
//		PlusOne po = new PlusOne();
//		int[] digits = {2,3,4,7};
//		int[] result = po.plusAnInteger(digits, 3249344);
//		System.out.println("plus an integer:");
//		for(int tmp: result){
//			System.out.print(tmp);
//		}
//		System.out.println();
//		
//		
//		FirstMissingPositive fmp = new FirstMissingPositive();
//		int[] fmparr = {-9,-3,-1,-5,3,6,2,1,5};
//		System.out.println("first missing positive: "+fmp.firstMissingPositive(fmparr));
//		
//		
//		
//		GrayCode gc = new GrayCode();
//		gc.grayCode(1);
		
	}

}
