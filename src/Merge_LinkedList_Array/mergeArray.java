package Merge_LinkedList_Array;

/**
 * given two sorted array, merge them into one array.
 * 
 * 
 * @author haozheng
 * 
 */

public class mergeArray {

	public int[] merge(int[] a, int[] b) {
		int[] h = new int[a.length + b.length];
		int l, r, c;
		l = r = c = 0;
		while (l < a.length && r < b.length) {
			if (a[l] <= b[r]) {
				h[c] = a[l];
				l++;
			} else {
				h[c] = b[r];
				r++;
			}
			c++;
		}

		int lR = a.length - l;
		for (int i = 0; i < lR; i++)
			h[c + i] = a[l + i];
		int rR = b.length - r;
		for (int i = 0; i < rR; i++)
			h[c + i] = b[r + i];

		return h;

	}

}
