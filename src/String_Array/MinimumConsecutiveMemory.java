package String_Array;

/**
 * 找内存满足标准的最小连续空间。 sample： ｛1，1，1，0，0，0，0，1，0，0，1，1｝，1代表内存被使用，
 * 0代表空闲，然后找出至少为2的最小连续空间的index，此例应该返回8
 * 
 * @author haozheng
 *
 */

public class MinimumConsecutiveMemory {

	public int minConsecutiveMemory(int[] arr) {

		int last = 0, i = 0, minLength = arr.length, minI = -1;

		while (i < arr.length) {
			if (arr[i] == 1)
				i++;
			else {
				last = i;
				while (i < arr.length && arr[i] == 0)
					i++;
				if ((i - last) <= minLength) {
					minLength = i - last;
					minI = last;
				}

			}
		}
		System.out.println("MCM Min length: " + minLength);
		return minI;

	}
}
