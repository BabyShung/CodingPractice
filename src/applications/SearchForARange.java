package applications;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {

		int[] range = { -1, -1 };

		int low = 0, high = A.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (A[mid] == target) {

				System.out.println("mid: " + mid);

				// once we find a target, next to specify the range
				// starting from the left, basically 0
				if (mid == 0 || A[mid - 1] < target) {
					// find the beginning
					range[0] = mid;
					// reset
					low = mid;
					high = A.length - 1;
					System.out.println("front");
				}
				if (mid == A.length - 1 || A[mid + 1] > target) {
					// find the end
					range[1] = mid;
					// reset
					low = 0;
					high = mid;
					System.out.println("end");
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
}
