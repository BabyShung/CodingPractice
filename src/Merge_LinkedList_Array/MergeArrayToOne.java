package Merge_LinkedList_Array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * 
 * @author haozheng
 *
 */

public class MergeArrayToOne {
	public void merge(int A[], int m, int B[], int n) {
		int last = m + n - 1, pa = m - 1, pb = n - 1;

		while (pa >= 0 && pb >= 0) {

			if (A[pa] > B[pb]) {
				A[last] = A[pa--];
			} else {
				A[last] = B[pb--];
			}
			last--;
		}
		while (pb >= 0) {
			A[last--] = B[pb--];
		}
	}
}
