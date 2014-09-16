package String_Array;

import java.util.HashMap;

public class HasAllUniqueCharacter {

	// int[] -- better than the boolean[]
	public boolean hasAllUniqueChar(String str) {
		if (str == null || str.isEmpty())
			return true;

		boolean[] r = new boolean[256];

		int len = str.length();
		// process the int array
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			if (r[tmp])
				return false;
			r[tmp] = true;
		}
		return true;
	}

	// int[]
	public boolean hasAllUniqueCharWorse(String str) {

		if (str == null || str.isEmpty())
			return true;

		int[] r = new int[256];

		int len = str.length();
		// process the int array
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			r[tmp]++;
		}
		// second scan
		for (int i = 0; i < r.length; i++) {
			if (r[i] > 1)
				return false;
		}
		return true;
	}

	// hash table - common one char with two byte
	public boolean hasAllUniqueCharHM(String str) {

		if (str == null || str.isEmpty())
			return true;

		HashMap<Character, Object> hm = new HashMap<>();
		Object once = new Object(), multi = new Object();

		int len = str.length();
		// process the int array
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			if (hm.get(tmp) == null)
				hm.put(tmp, once);
			else if (hm.get(tmp) == once)
				hm.put(tmp, multi);
		}
		// second scan
		for (Object obj : hm.values()) {
			if (obj != once)
				return false;
		}
		return true;
	}
}
