package String_Array;

public class Atoi_StringToInt {
	public int atoi(String s) {

		if (s == null || s.isEmpty())
			return 0;
		// this is still O(n) space
		s = s.trim();
		boolean negative = false;
		int i = 0;
		if (s.charAt(i) == '-') {
			negative = true;
			i++;
		} else if (s.charAt(i) == '+')
			i++;

		double num = 0;
		int len = s.length();
		while (i < len) {
			char tmp = s.charAt(i);
			if (tmp >= '0' && tmp <= '9')
				num = num * 10 + (int) (tmp - '0');
			else
				break;
			i++;
		}

		if (negative)
			num *= -1;

		if (num > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (num < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) num;
	}

	// truely O(1) space
	public int atoiByHao(String str) {
		if (str.isEmpty())
			return 0;
		int i = 0;
		while (str.charAt(i) == ' ')
			i++;
		boolean negative = false;
		if (str.charAt(i) == '-') {
			negative = true;
			i++;
		} else if (str.charAt(i) == '+')
			i++;
		double res = 0;
		while (i < str.length()) {
			char tmp = str.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				res = res * 10 + (int) (tmp - '0');
			} else {
				break;
			}
			i++;
		}
		if (negative)
			res *= -1;
		if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (res < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) res;
	}
}
