package applications;

/**
 * String matching (StrStr)
 * 
 * 
 * 
 * @author haozheng
 * 
 */

public class strstr {
	/**
	 * ---A B A B A C
	 * 
	 * -1 0 0 1 2 3 0
	 */

	private void buildNextTable(String pattern, int[] next) {
		next[0] = -1;
		for (int i = 2; i <= pattern.length(); ++i) {
			int j = next[i - 1];
			while (j > -1 && pattern.charAt(i - 1) != pattern.charAt(j))
				j = next[j];
			if (j > -1)
				next[i] = j + 1;
		}
	}

	public String strStr(String haystack, String needle) {
		int n = haystack.length(), m = needle.length();
		if (m == 0)
			return haystack;
		if (n < m)
			return null;
		int[] next = new int[m + 1];
		buildNextTable(needle, next);
		int offset = 0, start = 0;
		while (offset < n) {
			if (haystack.charAt(offset) == needle.charAt(start)) {
				++offset;
				if (++start == m) {
					return new StringBuilder().append(needle)
							.append(haystack.toCharArray(), offset, n - offset)
							.toString();
				}
			} else if (start > 0) {
				start = next[start];
			} else {
				++offset;
			}
		}
		return null;
	}
}
