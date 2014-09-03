package applications;

/**
 * Given a non-negative integer n, representing the total number of bits in the
 * gray code, and a non-negative integer k, print the k-th code in the gray code
 * sequence. A gray code sequence must begin with 0.
 * 
 * Why we interest in k-th code?
 * 
 * Notice that Gray Code can be used to solve Tower of Hanoi problem in that the
 * bit sequence we flips in each step is same as the ordinal of the disk to be
 * moved in each step. E.g. suppose n=3, to generate a gray code sequence, we
 * flips bits of previous number in the following order: 1 - 2 - 1 - 3 - 1 - 2 -
 * 1
 * 
 * code  ordial
 *  000     000   <- same
 *	001     001   <- same
 *	011     010   <- flip bit 0
 *	010     011   <- flip bit 0
 *	110     100   <- flip bit 1
 *	111     101   <- flip bit 1
 *	101     110   <- flip bits 11
 * 	100     111   <- flip bits 11
 * 
 * @author haozheng
 *
 */
public class KthGrayCode {
	public int kthGrayCode(int k) {  
		   return k ^ (k>>1);  
	} 
}
