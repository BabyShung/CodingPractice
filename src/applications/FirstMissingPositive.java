package applications;

/**
 * firstMissingPositive
 * 
 * Given an unsorted integer array, find the first missing positive integer. For
 * example, given [1,2,0] return 3, and [3,4,-1,1] return 2. Your algorithm
 * should run in O(n) time and uses constant space.
 * 
 * difficult:
 * 
 * The idea is that in an unsorted array, get the first missing positive
 * integer. EG: { -8,1,2,3,4,5,7,8,9,-1,-2}
 * 
 * Since the positive integer starts from 1, the FMP in this case is 6. How to
 * do that in O(n) time?
 * 
 * If you have a positive int at index i (A[i] = x), we should swap it to A[x-1]
 * as the right place
 * 
 * EG: if A[5] = 1, then 1 should be swapped to A[1-1] = A[0] ------> A[0] = 1
 * 
 * 
 * So the first scan, should have four conditions
 * 
 * 1.if negative, ignore
 * 
 * 2.if positive, check if A[i] <= A.length
 * 
 * 3.if A[i] != i + 1
 * 
 * 4.if A[i] != A[A[i] - 1]
 * 
 * if all four is satisfied, swap A[i] and A[A[i] - 1]. Otherwise, i++
 * 
 * 
 * @author haozheng
 * 
 */

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

	public int firstMissingPositive2(int[] A) {
		// in-place swap (bucket sort)
		for (int i = 0; i < A.length; i++) {
			while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[i] != A[A[i] - 1]) {
				int temp = A[A[i] - 1];// swap
				A[A[i] - 1] = A[i];
				A[i] = temp;
			}
		}
		// find the first positive missing integer
		int index = 0;
		while (index < A.length && A[index] == index + 1)
			++index;
		return index + 1;
	}

}
