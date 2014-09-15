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
}
