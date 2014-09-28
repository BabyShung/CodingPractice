package String_Array;

public class CountWords {

	public int countTheWords(String s) {

		if (s == null || s.isEmpty())
			return 0;

		char[] arr = s.toCharArray();

		int i = 0, count = 0;

		while (i < arr.length) {

			if (arr[i] == ' ') {
				i++;
			} else {
				while (i < arr.length && arr[i] != ' ')
					i++;
				// completely find a word
				count++;
			}
		}
		return count;
	}

}
