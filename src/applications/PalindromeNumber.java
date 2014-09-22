package applications;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author haozheng
 *
 */

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		// make a reverse
		long rev = 0, origin = x;
		while (x > 0) {
			rev = x % 10 + rev * 10;
			x /= 10;
		}
		return (origin == rev);
	}

	public boolean isPalindrome2(int x) {
		if (x < 0)
			return false;

		// what is the highest digit?
		int div = 10; // start from 10 since single digit number is palindrome
		while (x / div >= 10)
			div *= 10;

		// is it palindrome?
		while (x >= 10) {
			int lDigit = x / div;
			int rDigit = x % 10;
			if (lDigit != rDigit)
				return false;
			x = (x % div) / 10;
			// lower the highest digit
			div /= 100;
		}

		return true;
	}
}
