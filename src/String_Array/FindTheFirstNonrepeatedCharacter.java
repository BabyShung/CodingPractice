package String_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * find the first nonrepeated character
 * 
 * 1. O(n^2) two for loop
 * 
 * 2. O(n)
 * 
 * ----if the string contains some UTF16 two chars character, using codepoint as
 * key to solve that
 * 
 * ----if the string contains only most common characters (expressed by one
 * char:two bytes), we can use character as key to solve that
 * 
 * 
 * 
 * @author haozheng
 *
 */

public class FindTheFirstNonrepeatedCharacter {

	public Character findTheFirstNonrepeatedNaive(String str) {

		Map<Character, Object> hm = new HashMap<>();

		Object once = new Object(), multi = new Object();

		Object current;

		int len = str.length();
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			current = hm.get(tmp);
			if (current == null)// not exist, put once
				hm.put(tmp, once);
			else if (current == once)// put multi
				hm.put(tmp, multi);
		}
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			if (hm.get(tmp) == once)
				return tmp;
		}
		return null;
	}

	public String findTheFirstNonrepeated(String str) {

		Map<Integer, Object> hm = new HashMap<>();

		Object once = new Object(), multi = new Object();

		Object current;

		for (int i = 0; i < str.length();) {

			int codePoint = str.codePointAt(i);
			i += Character.charCount(codePoint);

			current = hm.get(codePoint);
			if (current == null) {// not exist, put in
				hm.put(codePoint, once);
			} else if (current == once) { // once, make it multi
				hm.put(codePoint, multi);
			}// else, already multi, ignore
		}

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			i += Character.charCount(codePoint);

			if (hm.get(codePoint) == once) {
				return new String(Character.toChars(codePoint));
			}
		}

		return null;

	}

}
