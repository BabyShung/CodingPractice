package Numbers;

/**
 * Given an integer, check if it is a palindrome without using extra space, O(1)
 * space is acceptable
 * 
 * sol1:compare left and right digit, if equal, then chop left and right off
 * keep on repeating
 * 
 * 
 * sol2:reverse int, might overflow
 * 
 * @author haozheng
 * 
 */
public class IntPalidrome {

	public boolean isIntPalidrome(int n) {

		if (n < 0)
			return false;

		int leftDivisor = 1;
		while (n / leftDivisor >= 10) {
			leftDivisor *= 10;
		}
		int left = n / leftDivisor;
		int right = n % 10;
		while (n != 0) {
			if (left != right)
				return false;
			// chop left and right
			n = n % leftDivisor / 10;
			leftDivisor /= 100;
		}
		return true;

	}

	// this method might overflow, since rev can be 9876523211
	public boolean isIntPalidrome2(int n) {
		if (n < 0)
			return false;
		int rev = 0, cn = n;
		while (cn != 0) {
			rev = rev * 10 + cn % 10;
			cn /= 10;
		}
		if (rev == n)
			return true;
		else
			return false;
	}

	public int reverse(int x) {

		int newN = 0;
		while (x != 0) {
			newN = newN * 10 + x % 10;
			x /= 10;

		}
		return newN;
	}
}
