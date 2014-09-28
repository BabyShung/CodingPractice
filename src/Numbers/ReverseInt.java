package Numbers;

public class ReverseInt {
	public int reverse(int x) {
		long l = 0;
		while (x != 0) {
			l = l * 10 + x % 10;
			x /= 10;
		}
		return (int) l;
	}
}
