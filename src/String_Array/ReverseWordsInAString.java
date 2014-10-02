package String_Array;

public class ReverseWordsInAString {

	public String reverseWordsByHao(String s) {
		if (s == null)
			return s;

		s = removeMultiSpaces(s);
		if (s.isEmpty())
			return s;

		// reverse whole
		char[] arr = s.toCharArray();
		reverse(arr, 0, arr.length - 1);

		// scan one time
		int i = 0, last = 0;
		while (i < arr.length) {
			if (arr[i] == ' ')
				i++;
			else {
				last = i;
				while (i < arr.length && arr[i] != ' ')
					i++;
				// find a word and reverse
				reverse(arr, last, i - 1);
				i++;
			}
		}
		return new String(arr);
	}

	private void reverse(char[] arr, int f, int r) {
		for (int i = f; i < (f + r + 1) / 2; i++) {
			swap(arr, i, f + r - i);
		}
	}

	private void swap(char[] arr, int f, int r) {
		char tmp = arr[f];
		arr[f] = arr[r];
		arr[r] = tmp;
	}

	private String removeMultiSpaces(String s) {
		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ')
			i++;
		if (i == s.length())
			return "";

		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			if (s.charAt(i) == ' ') {
				while (i < s.length() && s.charAt(i) == ' ')
					i++;
				// find lots of space but just add one
				sb.append(' ');
			} else {
				sb.append(s.charAt(i));
				i++;
			}
		}
		if (sb.charAt(sb.length() - 1) == ' ')
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
