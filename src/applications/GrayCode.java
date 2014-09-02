package applications;

import java.util.ArrayList;

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

	public ArrayList<Integer> grayCode(int n) {
		// remember: 1<<n means 2^n -> 1<<0 = 2^0 = 1; 1<<1 = 2^1 = 2 ...
		// the size is generalized from 0,1; 00,01,11,10;
		// 000,001,011,010,110,111,101,100;

		ArrayList<Integer> results = new ArrayList<Integer>(1 << n);
		results.add(0);
		System.out.println(Integer.toBinaryString(0) + " --- must have");
		for (int i = 0; i < n; i++) {
			int flipper = 1 << i;
			for (int j = results.size() - 1; j >= 0; --j) {

				int newBit = results.get(j) | flipper;
				results.add(newBit);
				System.out.println(Integer.toBinaryString(newBit));
			}
		}
		return results;
	}

}
