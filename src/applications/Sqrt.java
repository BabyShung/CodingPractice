package applications;

public class Sqrt {
	public int sqrt(int x) {

		if (x < 2)
			return x;

		int f = 0;
		int r = x;

		int m;

		// at first we know r is larger than f
		// so the condition
		while (f + 1 < r) {
			// get half x
			m = (f + r) / 2;

			int div = x / m;
			if (div == m) {
				return m;
			} else if (div > m) {
				f = m;
			} else {
				r = m;
			}

		}
		return f;

	}
}
