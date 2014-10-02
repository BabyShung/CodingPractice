package PointersToMiddle;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

import java.util.Arrays;
import java.util.HashMap;

public class Sum2 {
	// O(n) time and space
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] r = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int diff = target - numbers[i];
			if (hm.containsKey(diff)) {
				r[0] = hm.get(diff) + 1;
				r[1] = i + 1;
			} else {
				hm.put(numbers[i], i);
			}
		}
		return r;
	}

	public int[] twoSumOlogN(int[] numbers, int target) {

		Arrays.sort(numbers);
		int i = 0, j = numbers.length - 1;

		while (i != j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { i + 1, j + 1 };
			} else if (sum > target) {// move last point
				j--;
			} else {
				i++;
			}
		}
		return new int[2];
	}
}
