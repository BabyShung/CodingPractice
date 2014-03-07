package applications;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true
 * 
 * @author haozheng
 * 
 */

public class ValidNumber {

	// reg exp:
	// (space)*[+-]?([0-9]+|[0-9]*\.[0-9]+|[0-9]+\.[0-9]*)([eE][+-]?[0-9]+)?(space)*$

	public boolean isNumber(String s) {
		return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
	}

	public boolean isNumber2(String s) {
		s = s.toLowerCase();
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return s.charAt(s.length() - 1) != 'f'
				&& s.charAt(s.length() - 1) != 'd';
	}

	/**
	 * Using FSM (finite state machine) O(n) time and O(5*9) = O(1) space
	 * 
	 */
	private enum Type {
		Space(0), Sign(1), Digit(2), Dot(3), Exp(4), Null(-1);
		private int type;

		private Type(int t) {
			type = t;
		}

		public int getType() {
			return type;
		}
	}

	public boolean isNumber3(String s) {
		int[][] states = { { 0, 8, -1, -1, 8, -1, -1, 8, 8 },
				{ 2, -1, -1, -1, -1, 6, -1, -1, -1 },
				{ 1, 1, 1, 4, 4, 7, 7, 7, -1 },
				{ 3, 4, 3, -1, -1, -1, -1, -1, -1 },
				{ -1, 5, -1, -1, 5, -1, -1, -1, -1 } };

		int state = 0;
		for (Character c : s.toCharArray()) {
			Type inputType = Type.Null;
			if (c == ' ') {
				inputType = Type.Space;
			} else if (c == '+' || c == '-') {
				inputType = Type.Sign;
			} else if (c >= '0' && c <= '9') {
				inputType = Type.Digit;
			} else if (c == '.') {
				inputType = Type.Dot;
			} else if (c == 'e' || c == 'E') {
				inputType = Type.Exp;
			} else {
				return false; // invalid input
			}

			state = states[inputType.getType()][state];
			if (state < 0) { // invalid state transition
				return false;
			}
		}

		return (state == 1 || state == 4 || state == 7 || state == 8);
	}
}
