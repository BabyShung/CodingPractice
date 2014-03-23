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
}
