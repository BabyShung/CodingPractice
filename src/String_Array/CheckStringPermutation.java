package String_Array;

import java.util.HashMap;

public class CheckStringPermutation {

	// int[]
	public boolean isPermutation(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();

		if (aLen != bLen)
			return false;

		int[] r = new int[256];

		for (int i = 0; i < aLen; i++) {
			char tmp = a.charAt(i);
			r[tmp]++;
		}

		for (int i = 0; i < bLen; i++) {
			char tmp = b.charAt(i);
			if (--r[tmp] < 0)
				return false;
		}
		return true;

	}

	// hash table
	public boolean isPermutationHM(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();

		if (aLen != bLen)
			return false;

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < aLen; i++) {
			char tmp = a.charAt(i);
			Integer value = hm.get(tmp);
			if (value == null)
				hm.put(tmp, 1);
			else
				hm.put(tmp, ++value);
		}

		for (int i = 0; i < bLen; i++) {
			char tmp = b.charAt(i);
			Integer value = hm.get(tmp);
			if (value == null || --value < 0)
				return false;
			hm.put(tmp, value);
		}
		return true;
	}

}
