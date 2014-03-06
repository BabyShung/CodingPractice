package applications;

public class Pow {

	public double pow(double x, int n) {// O(logn),recursive
		// doesn't work for 1.00000, -2147483648
		// since java int [-2147483648,2147483647]
		// and Math.abs(-2147483648) = -2147483648, bug since out of range
		int exp = Math.abs(n);
		double res = powRec(x, exp);
		return (n > 0) ? res : 1.0 / res;
	}

	private double powRec(double x, int n) {
		if (n == 0)
			return 1;
		double half = powRec(x, n >> 1);

		double res = half * half;
		if ((n & 1) == 1)// if n%2 is odd
			res *= x;
		// else nothing
		return res;
	}

	public double pow2(double x, int n) {// O(logn),recursive
		if (n == 0)
			return 1;
		int exp = Math.abs(n);
		double half = pow(x, exp >> 1);
		double res = half * half;
		if ((exp & 1) == 1)// if n%2 is odd
			res *= x;
		// else nothing

		return (n > 0) ? res : 1.0 / res;
	}

	public double pow3(double x, int n) {// O(logn),iterative
		double result = 1;
		for (int m = Math.abs(n); m > 0; x *= x, m >>= 1) {
			if ((m & 1) == 1)// if m%2 is odd
				result *= x;
		}
		return (n >= 0) ? result : 1.0 / (result);
	}

	public double pow4(double x, int n) {// O(n), iterative
		double result = 1;
		if (n == 0)
			return result;
		while (n > 0) {// if n is positive
			result *= x;
			--n;
		}
		while (n < 0) {// if n is negative
			result /= x;
			++n;
		}
		return result;
	}

}
