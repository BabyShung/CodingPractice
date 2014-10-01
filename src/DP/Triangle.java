package DP;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 * 2
 * |\
 * 3 4
 * |\|\
 * 6 5 7
 * |\|\|\
 * 4 1 8 3
 * 
 * 
 * valueSum[i][j] = valueSum[i - 1][j - 1] + valueSum[i - 1][j]
 * 
 * Base case: valueSum[i][j] = valueSum[i - 1][j], i = 0 valueSum[i][j] =
 * valueSum[i - 1][j - 1], i = j
 * 
 * 
 * 
 * @author haozheng
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null)
			return 0;
		int n = triangle.size();
		int[][] valueSum = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (i == 0 && j == 0)
					valueSum[i][j] = triangle.get(0).get(0);
				else
					valueSum[i][j] = triangle.get(i).get(j)
							+ Math.min((i != j ? valueSum[i - 1][j]
									: Integer.MAX_VALUE),
									(j > 0 ? valueSum[i - 1][j - 1]
											: Integer.MAX_VALUE));
			}
		}
		Arrays.sort(valueSum[n - 1]);
		return valueSum[n - 1][0];
	}
}
