package applications;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author haozheng
 * 
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {

		if (digits.length == 0)
			return null;

		int i;
		for (i = digits.length - 1; i >= 0; i--) {
			digits[i] += 1;
			if (digits[i] == 10) {
				digits[i] = 0;
				// get to a pre-digit

			} else {
				break;
			}

		}
		if (i == -1) {// head digit is 9 and became 0, other digits should all
						// be 0 except the first be 1
			int[] newNum = new int[digits.length + 1];
			newNum[0] = 1;
			return newNum;
		}

		return digits;

	}

	public int[] plusAnInteger(int[] digits, int n) {

		if (digits.length == 0)
			return null;

		for (int i = digits.length - 1; i >= 0; i--) {
			if (n == 0)
				return digits;

			int ld = n % 10;

			digits[i] += ld;
			n /= 10;

			if (digits[i] >= 10) {
				digits[i] -= 10;
				n++;
			}
		}

		int m = 0, y = n;
		while (y != 0) {
			y /= 10;
			m++;
		}

		int[] newA = new int[digits.length + m];
		System.arraycopy(digits, 0, newA, m, digits.length);
		for (int j = m - 1; j >= 0; j--) {
			newA[j] = n % 10;
			n /= 10;
		}
		return newA;
	}

}
