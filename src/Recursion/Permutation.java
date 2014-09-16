package Recursion;

import java.util.ArrayList;

public class Permutation {

	// given [1,2,3]
	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		// base case----

		// empty input
		if (num.length == 0)
			return results;

		// only one
		if (num.length == 1) {
			ArrayList<Integer> perm = new ArrayList<Integer>();
			perm.add(num[0]);
			results.add(perm);
			return results;
		}

		// recursive case
		for (int i = 0; i < num.length; i++) {

			// copy a new array of n-1 numbers
			int[] subset = new int[num.length - 1];
			for (int j = 0; j < i; j++)
				subset[j] = num[j];

			for (int j = i + 1; j < num.length; ++j)
				subset[j - 1] = num[j];
			// append the current number to the end of pernutations of n-1
			// subset
			for (ArrayList<Integer> perm : permute(subset)) {
				perm.add(num[i]); // append to the end, O(1)
				results.add(perm);
			}
		}
		return results;
	}
}
