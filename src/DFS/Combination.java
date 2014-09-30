package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 		Think in DFS *************************
 * 
 * 				  1		     2	   3
 * 			  /   |   \     / \    |
 * 			 2    3    4   3   4   4
 * 			/|\   /\   |   /\  |   |
 * 		   3 4 5  4 5  5   4 5 5   5
 * 
 * 
 * 
 */


public class Combination {

	/**
	 * Sophie's solution, still thinking in DFS
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		if (n == 0 || k == 0)
			return res;
		dfs(1, n, k, tmp, res);
		return res;
	}

	private void dfs(int pos, int n, int k, List<Integer> tmp,
			List<List<Integer>> res) {

		if (k == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = pos; i <= n - k + 1; i++) {
			tmp.add(i);
			dfs(i + 1, n, k - 1, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
	}

	/**
	 * ...
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
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
			for (int j = 0; j < num; j++) { // loop through results from
											// (i-1)-level
				ArrayList<Integer> cur = results.get(j);
				int last = cur.get(cur.size() - 1);
				for (last += 1; last < n - k + 1; last++) {
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
