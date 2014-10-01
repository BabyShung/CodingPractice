package applications;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int level = 0; level < len; level++, len--) {
			int end = len - 1;
			for (int pos = level; pos < end; ++pos) {

				int tail = matrix.length - pos - 1;

				int tmp = matrix[level][pos];
				// left -> top
				matrix[level][pos] = matrix[tail][level];
				// bottom -> left
				matrix[tail][level] = matrix[end][tail];
				// right -> bottom
				matrix[end][tail] = matrix[pos][end];
				// top -> right
				matrix[pos][end] = tmp;
				
				String s;
				s.sub
			}
		}
	}

	public void rotateTest(int[][] matrix) {
		for (int level = 0, len = matrix.length; level < len; level++, len--) {
			int end = len - 1;
			for (int pos = level; pos < end; ++pos) {

				int tail = matrix.length - pos - 1;

				int tmp = matrix[level][pos];
				System.out.println("M[" + level + "][" + pos + "] to tmp");
				// left -> top
				matrix[level][pos] = matrix[tail][level];
				System.out.println("M[" + tail + "][" + level + "] to M["
						+ level + "][" + pos + "]");
				// bottom -> left
				matrix[tail][level] = matrix[end][tail];
				System.out.println("M[" + end + "][" + tail + "] to M[" + tail
						+ "][" + level + "]");
				// right -> bottom
				matrix[end][tail] = matrix[pos][end];
				System.out.println("M[" + pos + "][" + end + "] to M[" + end
						+ "][" + tail + "]");
				// top -> right
				matrix[pos][end] = tmp;
				System.out.println("tmp to M[" + pos + "][" + end + "]");
			}
		}
	}
}
