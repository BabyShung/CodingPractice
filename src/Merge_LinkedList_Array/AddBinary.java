package Merge_LinkedList_Array;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author haozheng
 *
 */

public class AddBinary {

	public String addBinaryByHao(String a, String b) {// O(n)

		StringBuilder sb = new StringBuilder();

		int lastA = a.length() - 1;
		int lastB = b.length() - 1;
		int carry = 0;

		while (lastA >= 0 || lastB >= 0 || carry > 0) {
			int num1 = lastA >= 0 ? a.charAt(lastA--) - '0' : 0;
			int num2 = lastB >= 0 ? b.charAt(lastB--) - '0' : 0;
			int current = (num1 + num2 + carry) & 1; // means mod 2
			carry = (num1 + num2 + carry) >> 1; // means divided by 2
			sb.append(current);
		}
		return sb.reverse().toString();
	}

	// too verbose
	public String addBinary(String a, String b) {

		StringBuilder aa = new StringBuilder(a);
		aa.reverse();
		StringBuilder bb = new StringBuilder(b);
		bb.reverse();

		StringBuilder r = new StringBuilder();

		int i = 0;
		char carry = '0';
		while (i < aa.length() && i < bb.length()) {

			if (aa.charAt(i) == bb.charAt(i)) { // 0 0 or 1 1

				r.append(carry);
				carry = aa.charAt(i);

			} else {// 1 0 or 0 1
				r.append((carry == '0' ? '1' : '0'));
			}

			i++;
		}

		while (i < aa.length()) {
			if (aa.charAt(i) == '0') {
				r.append(carry);
				carry = '0';

			} else { // current char is 1
				r.append((carry == '0' ? '1' : '0'));
			}
			i++;
		}
		while (i < bb.length()) {
			if (bb.charAt(i) == '0') {
				r.append(carry);
				carry = '0';

			} else { // current char is 1
				r.append((carry == '0' ? '1' : '0'));
			}
			i++;
		}

		// finally get out of the loop and check the last bit by checking carry
		if (carry == '1')
			r.append(carry);
		return r.reverse().toString();

	}
}
