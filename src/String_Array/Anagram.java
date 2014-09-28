package String_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return a list of all groups of strings that are
 * anagrams. Note: All inputs will be in lower-case.
 * 
 * For example, ["tea","and","ace","ad","eat","dan"] => ["and", "dan", "tea",
 * "eat"]
 * 
 * Using HashTable + List(either arrayList or linkedList), it's a variant of
 * bucketSort!
 * 
 * @author haozheng
 *
 */

public class Anagram {
	public List<String> anagrams(String[] strs) {

		Map<String, List<String>> hm = new HashMap<>();

		for (String s : strs) {

			String sorted = labelString(s);
			// String sorted = sortString(s);
			if (!hm.containsKey(sorted))
				hm.put(sorted, new ArrayList<String>());
			List<String> l = hm.get(sorted);
			l.add(s);
		}

		List<String> res = new ArrayList<>();

		for (List<String> al : hm.values()) {
			if (al.size() > 1)
				res.addAll(al);
		}
		return res;

	}

	private String labelString(String s) {// O(n)
		int[] asc2 = new int[256];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char tmp = s.charAt(i);
			asc2[tmp]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < asc2.length; i++) {
			if (asc2[i] != 0)
				sb.append((char) i).append(asc2[i]);
		}
		return sb.toString();
	}

	private String sortString(String s) {// O(nlogn)
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
