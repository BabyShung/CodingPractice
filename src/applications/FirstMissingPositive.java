package applications;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		// in-place swap (bucket sort)
		int i = 0;
		for(int tmp: A){
			System.out.print(tmp+" ");
		}
		System.out.println();
		while (i < A.length) {
			if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[i] != A[A[i] - 1]) {
				System.out.println("Swapping: "+A[i]+" and "+A[A[i] - 1]);
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
			} else {
				++i;
			}
		}
		// find the first positive missing integer
		i = 0;
		
		for(int tmp: A){
			System.out.print(tmp+" ");
		}
		System.out.println();
		while (i < A.length && A[i] == i + 1)
			++i;
		return i + 1;
	}

	public int firstMissingPositive2(int[] A) {
		// in-place swap (bucket sort)
		for (int i = 0; i < A.length; i++) {
			while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[i] != A[A[i] - 1]) {
				int temp = A[A[i] - 1];//swap
				A[A[i] - 1] = A[i];
				A[i] = temp;
			}
		}
		// find the first positive missing integer
		int index = 0;
		while (index < A.length && A[index] == index + 1)
			++index;
		return index + 1;
	}

}
