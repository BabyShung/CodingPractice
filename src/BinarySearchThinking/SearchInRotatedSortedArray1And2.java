package BinarySearchThinking;

/**
 * 
 * just judge the cases that we need to shink to the right:
 * 
 * 1.array normal order: target > A[m] && A[r] > A[f]
 * 
 * 
 * 
 * 2.rotated, the largest one is before the middle:
 * 
 * Target <= A[r] && target > A[m] && A[r] > A[m]
 * 
 * 3.rotated, the largest one is between the middle to the end:
 * 
 * A[m] > A[r] && (target <= A[r] || target > A[m]
 * 
 * @author haozheng
 *
 */

public class SearchInRotatedSortedArray1And2 {
	public int search(int[] A, int target) {

		int f = 0, r = A.length - 1;

		while (f <= r) {
			int m = (f + r) / 2;

			if (A[m] == target)
				return m;
			else if ((target > A[m] && A[r] > A[f])
					|| (target <= A[r] && target > A[m] && A[r] > A[m])
					|| (A[m] > A[r] && (target <= A[r] || target > A[m]))) {
				f = m + 1;
			} else { // shinks to the left
				r = m - 1;
			}
		}
		return -1;
	}

	// with duplicates
	public boolean searchII(int[] A, int target) {
		int f = 0, r = A.length - 1;

		// just add this part to filter the duplicates
		while (f < r && A[f] == A[r]) {
			if (A[f] == target)
				return true;
			++f;
			--r;
		}

		while (f <= r) {
			int m = (f + r) / 2;

			if (A[m] == target)
				return true;
			else if ((target > A[m] && A[r] > A[f])
					|| (target <= A[r] && target > A[m] && A[r] > A[m])
					|| (A[m] > A[r] && (target <= A[r] || target > A[m]))) {
				f = m + 1;
			} else { // shinks to the left
				r = m - 1;
			}
		}
		return false;
	}
}
