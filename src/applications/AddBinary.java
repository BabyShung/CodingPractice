package applications;

public class AddBinary {
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
