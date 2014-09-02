package applications;

public class RemoveVowels {

	//Hao
	public String removeVowelsIterative(String str) {

		if (str.isEmpty())
			return str;

		StringBuilder sb = new StringBuilder();

		int len = str.length();
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			if (!isVowels(tmp))
				sb.append(tmp);
		}
		return sb.toString();

	}

	private boolean isVowels(char c) {
		// just in case upper case
		c = Character.toLowerCase(c);

		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else
			return false;
	}

	/*
	 * removeVowels - a recursive method that returns string formed by removing
	 * all lower-case vowels (a, e, i, o, u) from the String str.
	 */
	public String removeVowels(String str) {
		// base cases
		if (str == null) {
			return null;
		}
		if (str.equals("")) {
			return "";
		}

		// recursive case

		// Make a recursive call to remove vowels from the
		// rest of the string.
		String removedFromRest = removeVowels(str.substring(1));

		// If the first character in str is a vowel,
		// we don't include it in the return value.
		// If it isn't a vowel, we do include it.
		char first = Character.toLowerCase(str.charAt(0));
		if (first == 'a' || first == 'e' || first == 'i' || first == 'o'
				|| first == 'u') {
			return removedFromRest;
		} else {
			return first + removedFromRest;
		}
	}
}