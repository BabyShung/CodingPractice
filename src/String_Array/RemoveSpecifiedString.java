package String_Array;

import java.util.HashMap;

/**
 * 
 * a parent of the Remove Vowels
 * 
 * 
 * 1.use StringBuilder + HashMap/boolean[]
 * 
 * 2.use Array only + HashMap/boolean[] (StringBuilder overhead is stronger than
 * array?)
 * 
 * 
 * @author haozheng
 *
 */

public class RemoveSpecifiedString {

	// StringBuilder + HashMap
	public String removeChars(String str, String remove) {

		if (str == null || str.isEmpty())
			return str;

		StringBuilder sb = new StringBuilder();

		HashMap<Character, Boolean> hm = new HashMap<>();

		for (int i = 0; i < remove.length(); i++) {
			char tmp = remove.charAt(i);
			if (hm.get(tmp) == null)// not exist, make it true
				hm.put(tmp, true);
		}
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (hm.get(tmp) == null) {// meaning it should be added
				sb.append(tmp);
			}
		}
		return sb.toString();
	}

	// StringBuilder + boolean[]
	public String removeCharsSB_BOOL(String str, String remove) {
		if (str == null || str.isEmpty())
			return str;
		StringBuilder sb = new StringBuilder();
		boolean[] r = new boolean[256];

		for (int i = 0; i < remove.length(); i++) {
			char tmp = remove.charAt(i);
			if (!r[tmp])
				r[tmp] = true;
		}
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (!r[tmp])
				sb.append(tmp);
		}
		return sb.toString();
	}

	// Array + HashMap
	public String removeCharsARRAY_HM(String str, String remove) {
		if (str == null || str.isEmpty())
			return str;

		int last = 0;
		char[] arr = str.toCharArray();

		HashMap<Character, Boolean> hm = new HashMap<>();

		for (int i = 0; i < remove.length(); i++) {
			char tmp = remove.charAt(i);
			if (hm.get(tmp) == null)// not exist, make it true
				hm.put(tmp, true);
		}
		for (int i = 0; i < arr.length; i++) {
			char tmp = arr[i];
			if (hm.get(tmp) == null) {// meaning it should be added
				arr[last++] = tmp;
			}
		}
		return new String(arr, 0, last);
	}
	
	// Array + boolean[]
		public String removeCharsARRAY_BOOL(String str, String remove) {
			if (str == null || str.isEmpty())
				return str;

			int last = 0;
			char[] arr = str.toCharArray();

			boolean[] r = new boolean[256];

			for (int i = 0; i < remove.length(); i++) {
				char tmp = remove.charAt(i);
				if (!r[tmp])
					r[tmp] = true;
			}
			for (int i = 0; i < arr.length; i++) {
				char tmp = arr[i];
				if (!r[tmp]) {// meaning it should be added
					arr[last++] = tmp;
				}
			}
			return new String(arr, 0, last);
		}
}
