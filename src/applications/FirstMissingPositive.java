package applications;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		// in-place swap (bucket sort)
		int i = 0;
		while (i < A.length) {
			if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[i] != A[A[i] - 1]) {
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
			} else {
				++i;
			}
		}
		// find the first positive missing integer
		i = 0;
		while (i < A.length && A[i] == i + 1)
			++i;
		return i + 1;
	}
}
