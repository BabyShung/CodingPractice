package BinarySearchThinking;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {

		int f = 0, r = A.length - 1;
		int m;

		while (f <= r) {
			m = (f + r) / 2;

			if (A[m] >= target) { // important, this can help in the case with
									// multiple same value: {1,2,2,2,3} search 2
									// get index 1
				// move left
				r = m - 1;
			} else {
				f = m + 1;
			}
		}
		return f;

	}
}
