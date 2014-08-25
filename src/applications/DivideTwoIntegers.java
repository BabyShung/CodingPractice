package applications;

import java.util.ArrayList;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * O(n) solution: dividend - divisor - divisor - divisor ... - divisor (n
 * divisors)
 * 
 * O(logn) better solution: use binary search thinking
 * 
 * 
 * First we generate all possible divisors from original divisor ( divisors
 * should all be smaller than dividend) EG: dd 100, ds 10
 * 
 * Arraylist: {10, 20, 40, 80} ( times 2, times 2, to get logn divisors)
 * 
 * Start from the largest: 80. Use dd - ds (100 - 80) quotient will be result +=
 * 1 << 3 (index) = 8 then 100 - 80 = 20 keep doing the same, until dd is <= 0,
 * and we will have a final quotient
 * 
 * special thing is the algo only deal with positive, since -2147483648 ->
 * 2147483648 is out of int. Thus we need to use cast both int to long and use
 * ABS, finally we check the relation between dd and ds, and determine whether
 * it is negative or positive
 * 
 * @author haozheng
 *
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {

		if (dividend == 0 || divisor == 1)
			return dividend;

		if (divisor == -1)
			return -dividend;

		long dd = Math.abs((long) dividend), ds = Math.abs((long) divisor);

		ArrayList<Long> divisors = new ArrayList<>();

		// create the possible lists in O(logn) time
		while (ds <= dd) {
			divisors.add(ds);
			ds = ds << 1;
		}

		int current = divisors.size() - 1;
		int result = 0;

		while (current >= 0 && dd > 0) {
			while (dd >= divisors.get(current)) {
				dd -= divisors.get(current);
				result += 1 << current;
			}
			current--;
		}

		return (dividend > 0) ^ (divisor > 0) ? -result : result;

	}
}
