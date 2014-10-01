package DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Classic DP:
 * 
 * numOfPath[i][j] = numOfPath[i - 1][j] + numOfPath[i][j - 1], i>0,j>0
 * numOfPath[i][j] = 1, i = 0 or j = 0 since there will be only one path
 * 
 * @author haozheng
 *
 */

public class UniquePath1And2 {
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;

		int[][] numOfPath = new int[m][n];

		for (int i = 0; i < m; i++) {
			numOfPath[i][0] = 1;
			for (int j = 1; j < n; j++) {
				if (i == 0)
					numOfPath[i][j] = 1;
				else
					numOfPath[i][j] = numOfPath[i - 1][j] + numOfPath[i][j - 1];
			}
		}
		return numOfPath[m - 1][n - 1];
	}

	/**
	 * unique path II
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0 || n == 0)
			return 0;
		if (obstacleGrid[0][0] == 1)
			return 0;

		int[][] numOfPath = new int[m][n];
		numOfPath[0][0] = 1;// since obstacleGrid[0][0] is empty

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (i == 0 && j == 0)
						numOfPath[0][0] = 1;
					else
						numOfPath[i][j] = (i > 0 ? numOfPath[i - 1][j] : 0)
								+ (j > 0 ? numOfPath[i][j - 1] : 0);
				}// else no need to calculate since numOfPath all initial 0
			}
		}
		return numOfPath[m - 1][n - 1];
	}
}
