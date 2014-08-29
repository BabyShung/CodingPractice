package BinarySearchThinking;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * 
 * Solution:
 * 
 * 1. traditional binary search, need to modify the A[m] == target part, not
 * easy and might make mistake
 * 
 * 2.Use searchInsertPosition function to help:
 * 
 * searchInsertPosition can find the leftmost position (if found, otherwise
 * return an assumed position), then just use it twice, one for target, one for
 * target + 1 to get the range, remember to specify the bounded case, be careful
 * 
 * 
 * @author haozheng
 *
 */

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {

		int[] range = { -1, -1 };

		int low = 0, high = A.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (A[mid] == target) {

				// once we find a target, next to specify the range
				// starting from the left, basically 0
				if (mid == 0 || A[mid - 1] < target) {
					// find the beginning
					range[0] = mid;
					// reset
					low = mid;
					high = A.length - 1;
				}
				if (mid == A.length - 1 || A[mid + 1] > target) {
					// find the end
					range[1] = mid;
					// reset
					low = 0;
					high = mid;
				}

				// the above is to check both, because you don't know you hit
				// the range head or the range end first

				// find the range
				if (range[0] > -1 && range[1] > -1)
					return range;

				// search range end first, continue searching for beginning in
				// (.., mid)
				if (range[0] < 0)
					high = mid - 1;
				else
					// search range head first continue searching for end in
					// (mid, ..)
					low = mid + 1;

			} else if (A[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return range;
	}

	// ///////// SOLUTION 2
	public int[] searchRange2(int[] A, int target) {

		int[] range = { -1, -1 };

		int left = searchInsert(A, target);
		int right = searchInsert(A, target + 1); // find the one behind the
													// right range element

		// check special cases

		if (left == right) {
			return range;
		} else {
			return new int[] { left, right - 1 };
		}

	}

	private int searchInsert(int[] A, int target) {

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
