package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Again, think of it in DFS way
 * 
 * 
 * @author haozheng
 *
 */

public class Permutation1And2 {

	// given [1,2,3]
	public List<List<Integer>> permute(int[] num) {

		List<List<Integer>> res = new ArrayList<>();

		List<Integer> tmp = new ArrayList<>();

		boolean[] visit = new boolean[num.length];

		Arrays.sort(num);

		dfs(res, tmp, num, visit);

		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] num,
			boolean[] visit) {

		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (visit[i] == false) {

				tmp.add(num[i]);

				visit[i] = true;

				dfs(res, tmp, num, visit);

				tmp.remove(tmp.size() - 1);

				visit[i] = false;
			}
		}

	}

	// only need to add one sentence
	public List<List<Integer>> permuteUnique(int[] num) {

		List<List<Integer>> res = new ArrayList<>();

		List<Integer> tmp = new ArrayList<>();

		boolean[] visit = new boolean[num.length];

		Arrays.sort(num);

		dfs2(res, tmp, num, visit);

		return res;
	}

	private void dfs2(List<List<Integer>> res, List<Integer> tmp, int[] num,
			boolean[] visit) {

		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (visit[i] == false) {

				tmp.add(num[i]);

				visit[i] = true;

				dfs2(res, tmp, num, visit);

				tmp.remove(tmp.size() - 1);

				visit[i] = false;

				while (i < num.length - 1 && num[i] == num[i + 1])
					i++;
			}
		}

	}
}
