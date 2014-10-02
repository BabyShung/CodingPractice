package String_Array;

import java.util.ArrayList;
import java.util.List;

public class CountWords {

	public int countTheWords(String s) {

		if (s == null || s.isEmpty())
			return 0;
		char[] arr = s.toCharArray();
		int i = 0, count = 0;
		while (i < arr.length) {
			if (arr[i] == ' ') {
				i++;
			} else {
				while (i < arr.length && arr[i] != ' ')
					i++;
				// completely find a word
				count++;
				i++;
			}
		}
		return count;
	}

	//solution 2 using extra space
	public int countTheWordsUsingSplit(String s) {
		if (s == null || s.isEmpty())
			return 0;
		List<String> res = splitSpaces(s);
		return res.size();
	}

	private List<String> splitSpaces(String s) {
		List<String> res = new ArrayList<>();
		int i = 0, last = 0, len = s.length();
		while (i < len) {
			char tmp = s.charAt(i);
			if (tmp == ' ') {
				i++;
			} else {
				last = i;
				while (i < len && s.charAt(i) != ' ')
					i++;
				// find a word and get the substring
				res.add(s.substring(last, i));
				i++;
			}
		}
		return res;
	}
}
