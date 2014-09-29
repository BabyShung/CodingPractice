package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1And2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(res, tmp, candidates, target, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> tmp,
			int[] candidates, int target, int pos) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = pos; i < candidates.length; i++) {
			tmp.add(candidates[i]);
			dfs(res, tmp, candidates, target - candidates[i], i);
			tmp.remove(tmp.size() - 1);
		}
	}

	/**
	 * II
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(candidates);
		dfs2(res, tmp, candidates, target, 0);
		return res;
	}

	private void dfs2(List<List<Integer>> res, List<Integer> tmp,
			int[] candidates, int target, int pos) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = pos; i < candidates.length; i++) {
			tmp.add(candidates[i]);
			dfs2(res, tmp, candidates, target - candidates[i], i + 1);
			tmp.remove(tmp.size() - 1);
			while (i < candidates.length - 1
					&& candidates[i] == candidates[i + 1])
				i++;
		}
	}
}
