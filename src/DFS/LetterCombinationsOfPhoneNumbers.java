package DFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumbers {
	public List<String> letterCombinations(String digits) {
		char[][] letters = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
				{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
				{ 'w', 'x', 'y', 'z' } };

		List<String> r = new ArrayList<>();
		dfs(letters, digits, "", r);
		return r;
	}

	private void dfs(char[][] letters, String digits, String tmp, List<String> r) {
		if (digits.length() == 0) {
			r.add(tmp);
			return;
		}
		for (int i = 0; i < letters[digits.charAt(0) - '0' - 1].length; i++) {
			dfs(letters, digits.substring(1), tmp
					+ letters[digits.charAt(0) - '0' - 1][i], r);
		}
	}
}
