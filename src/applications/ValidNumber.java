package applications;

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
}
