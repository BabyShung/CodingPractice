package applications;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * 
 * 
 * @author haozheng
 *
 */

public class GrayCode {

	// remember: 1<<n means 2^n -> 1<<0 = 2^0 = 1; 1<<1 = 2^1 = 2 ...
	// the size is generalized from 0,1; 00,01,11,10;
	// 000,001,011,010,110,111,101,100;
	public List<Integer> grayCode(int n) {

		ArrayList<Integer> r = new ArrayList<>(1 << n);

		r.add(0);

		for (int i = 0; i < n; i++) {
			int flipper = 1 << i;

			for (int j = r.size() - 1; j >= 0; j--) {
				r.add(flipper | r.get(j));
			}
		}

		return r;

	}

}
