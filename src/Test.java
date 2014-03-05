import java.util.Set;

import applications.IntPalidrome;
import applications.Pow;
import applications.SortedArrayIntersection;
import applications.mergeArray;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntPalidrome ip = new IntPalidrome();
		System.out.println(ip.isIntPalidrome(234323));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(ip.reverse(-1000000013));

		Pow p = new Pow();
		System.out.println(p.pow(10, -3));
		System.out.println(p.pow2(10, -3));

		mergeArray ma = new mergeArray();
		int[] a = { 3, 6, 7, 10 };
		int[] b = { 1, 3, 5, 8, 9, 11 };
		int[] r = ma.merge(a, b);

		SortedArrayIntersection sai = new SortedArrayIntersection();
		int[] c = { 1, 4, 5 };
		int[] d = { 1, 2, 3, 4, 5, 8, 9, 11 };
		Set<Integer> ss = sai.getSortedArrayIntersection(c, d);
		for (Integer tmp : ss)
			System.out.print(tmp + " ");
	}

}
