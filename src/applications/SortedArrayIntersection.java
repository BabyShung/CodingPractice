package applications;

/**
 * given two sorted array, find their intersection
 * 
 * Using HashSet
 * 
 * 
 */


import java.util.HashSet;
import java.util.Set;

public class SortedArrayIntersection {

	public Set<Integer> getSortedArrayIntersection(int[] a, int[] b) {

		Set<Integer> s = new HashSet<>();

		int l, r;
		l = r = 0;
		while (l < a.length && r < b.length) {

			if (a[l] == b[r]) {
				s.add(a[l]);// or arraylist.add
				l++;
				r++;
			} else if (a[l] < b[r])
				l++;
			else
				r++;
		}
		return s;
	}

}
