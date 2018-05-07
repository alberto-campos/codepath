/*
 * Given an array of non negative integers A, and a range (B, C),
 * find the number of continuous subsequences in the array which 
 * have sum S in the range [B, C] or B <= S <= C
 * 
 */

public class NumRange {
	public static void main(String[] args) {
		
		int[] A = { 10, 5, 1, 0, 2 };
		int B = 6;
		int C = 8;
		
		int[] A2 = { 80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 };
		int B2 = 99;
		int C2 = 269;
		
		System.out.println("Solution: " + getRangeCount(A, B, C));
		System.out.println("Solution2: " + getRangeCount(A2, B2, C2));
	}
	
	public static int getRangeCount(int[] A, int B, int C) {
		int count = 0;
		int size = A.length;
		if (size == 0 || A == null || B > C) {
			return count;
		} else {
			for (int i = 0; i < size; i++) {
				int sum = 0;
				for (int j = i; j < size; j++) {
					sum = sum + A[j];
					if (sum > C) {
						break;
					} else if ((sum >= B) && (sum <= C)) {
						count++;
					}
				}
			}
			return count;
		}	
	}
	
	
}