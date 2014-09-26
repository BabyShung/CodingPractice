package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets.
 * 
 * For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3],
 * [2,3], [1,2], [] ]
 * 
 * 
 * Take a real analysis, it is a modification of DFS
 * 
 * @author haozheng
 *
 */

public class Subset1And2 {
	public List<List<Integer>> subsets1(int[] S) {
		List<List<Integer>> r = new ArrayList<>();

		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(S);

		r.add(tmp);

		dfs(r, tmp, S, 0);
		return r;
	}

	private void dfs(List<List<Integer>> r, List<Integer> tmp, int[] S, int pos) {
		for (int i = pos; i < S.length; i++) {
			tmp.add(S[i]);

			r.add(new ArrayList<Integer>(tmp));

			dfs(r, tmp, S, i + 1);

			tmp.remove(tmp.size() - 1);
		}
	}

	public List<List<Integer>> subsets2(int[] S) {
		List<List<Integer>> r = new ArrayList<>();

		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(S);

		r.add(tmp);

		dfs2(r, tmp, S, 0);
		return r;
	}

	private void dfs2(List<List<Integer>> r, List<Integer> tmp, int[] S, int pos) {
		for (int i = pos; i < S.length; i++) {
			tmp.add(S[i]);

			r.add(new ArrayList<Integer>(tmp));

			dfs2(r, tmp, S, i + 1);

			tmp.remove(tmp.size() - 1);

			while (i < S.length - 1 && S[i] == S[i + 1])
				i++;
		}
	}
}
