package String_Array;

/**
 * how to convert an int to string?
 * 
 * 1.check if it is negative 2.calculate each digit
 * 
 * @author haozheng
 *
 */

public class Atoi_intToString {

	// O(n) time and O(1) space
	public String intToString(int num) {
		if (num == 0)
			return "0";
		boolean negative = false;
		if (num < 0) {
			negative = true;
			num = -num;
		}

		int divisor = 1;
		while (num / divisor >= 10)
			divisor *= 10;

		StringBuilder sb = new StringBuilder();

		if (negative)
			sb.append("-");

		while (divisor != 0) {
			int digit = num / divisor;
			sb.append(digit);
			num %= divisor;
			divisor /= 10;
		}

		return sb.toString();
	}

	// O(n) time and O(n) space
	public String intToStringW(int num) {
		if (num == 0)
			return "0";
		boolean negative = false;
		if (num < 0) {
			negative = true;
			num = -num;
		}
		int divisor = 1, count = 1;
		while (num / divisor >= 10) {
			divisor *= 10;
			count++;
		}
		StringBuilder sb = new StringBuilder();
		char[] arr = new char[count];

		if (negative)
			sb.append("-");
		int i = 0;
		while (num != 0) {
			arr[i++] = (char) (num % 10 + '0');
			num /= 10;
		}
		while (i > 0) {
			sb.append(arr[--i]);
		}
		return sb.toString();
	}
}
