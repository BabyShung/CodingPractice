package applications;

import java.util.ArrayList;

public class GrayCode {

	public ArrayList<Integer> grayCode(int n) {
		//remember: 1<<n means 2^n  -> 1<<0 = 1;  1<<1 = 2 ... 
		ArrayList<Integer> results = new ArrayList<Integer>(1 << n);
		results.add(0);
		System.out.println(0+ " --- must have");
		for (int i = 0; i < n; ++i) {
			int flipper = 1 << i;
			for (int j = results.size() - 1; j >= 0; --j) {
				
				int newBit = results.get(j) | flipper;
				results.add(newBit);
				System.out.println(newBit);
			}
		}
		return results;
	}

}
