package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

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

	// O(nlogn)
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

	// O(n) -- variant of Bucket sort!
	public void sortWithHM(String[] arr) {

		HashMap<String, LinkedList<String>> hm = new HashMap<>();

		for (String s : arr) {
			String sorted = sortString(s);

			if (!hm.containsKey(sorted))
				hm.put(sorted, new LinkedList<String>());
			LinkedList<String> l = hm.get(sorted);
			l.add(s);

			// LinkedList<String> list = hm.get(sorted);
			// if(list == null){
			// list = new LinkedList<>();
			// list.add(s);
			// hm.put(sorted, list);
			// }else{
			// list.add(s);
			// }
		}

		int i = 0;
		for (String s : hm.keySet()) {
			LinkedList<String> ll = hm.get(s);
			for (String tmp : ll) {
				arr[i++] = tmp;
			}
		}
	}

	private String sortString(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
