package DP;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Solution:
 * 
 * Similar to Unique path, but need to add the values in the grid and choose the
 * min one
 * 
 * 
 * @author haozheng
 *
 */

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		if (m == 0 || n == 0)
			return 0;

		int[][] valueSum = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					valueSum[i][j] = grid[0][0];
				else
					valueSum[i][j] = grid[i][j]
							+ Math.min((i > 0 ? valueSum[i - 1][j]
									: Integer.MAX_VALUE),
									(j > 0 ? valueSum[i][j - 1]
											: Integer.MAX_VALUE));
			}
		}
		return valueSum[m - 1][n - 1];
	}
}
