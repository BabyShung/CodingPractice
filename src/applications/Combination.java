package applications;

import java.util.ArrayList;

public class Combination {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		combineHelper(1, n, k, new ArrayList<Integer>(), res);
		return res;
	}

	private void combineHelper(int s, int n, int k, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> res) {
		if (n == 0)
			return;
		if (k == 0) {
			ArrayList<Integer> r = new ArrayList<Integer>(path);
			res.add(r);
			return;
		}

		for (int i = s; i <= n - k + 1; ++i) {
			path.add(i);
			combineHelper(i + 1, n, k - 1, path, res);
			path.remove(path.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> combineI(int n, int k) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		for (; k > 0; k--) {
			int num = results.size();
			// add first element
			if (num == 0) {
				for (int i = 1; i <= n - k + 1; i++) {
					ArrayList<Integer> res = new ArrayList<Integer>();
					res.add(i);
					results.add(res);
				}
				continue;
			}

			// append rest
			for (int j = 0; j < num; ++j) { // loop through results from
											// (i-1)-level
				ArrayList<Integer> cur = results.get(j);
				int last = cur.get(cur.size() - 1);
				for (last += 1; last < n - k + 1; ++last) {
					ArrayList<Integer> res = new ArrayList<Integer>(cur);
					res.add(last);
					results.add(res);
				}
				cur.add(last);
			}
		}

		return results;
	}
}
