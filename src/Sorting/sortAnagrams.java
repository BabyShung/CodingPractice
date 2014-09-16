package Sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a method to sort an array of strings so that all the anagrams are next
 * to each other.
 * 
 * Two solutions
 * 
 * 1.sort the whole array with a special comparator that also sorts the two
 * string to check equality
 * 
 * 
 * @author haozheng
 *
 */

public class sortAnagrams {

	public void sort(String[] arr) {

		Comparator<String> comp = new Comparator<String>() {
			private String sortString(String str) {
				char[] arr = str.toCharArray();
				Arrays.sort(arr);
				return new String(arr);
			}

			@Override
			public int compare(String o1, String o2) {
				return sortString(o1).compareTo(sortString(o2));
			}
		};
		Arrays.sort(arr, comp);
	}
}
