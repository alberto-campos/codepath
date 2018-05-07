/*
 * Find the kth smallest element in an unsorted array of non-negative integers.
 * 
 * Note: Using a basic Quick sort algorithm. This also works with a PriorityQueue.
 * 
 * It takes 2 steps: a) sort the array and b) locate the 'kth' number from the sorted array.
 * 
 */

public class KthSmallest {

	public static void main(String[] args) {

		int[] A = { 2, 1, 4, 3, 2 };
		int k = 4;

		int[] A2 = { 80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 };
		int k2 = 1;

		System.out.println("Solution: " + getKthSmallest(A, k));
		System.out.println("Solution2: " + getKthSmallest(A2, k2));
	}

	public static int getKthSmallest(final int[] A, int B) {
		int n = A.length;
		
		int k = quickSort(A, 0, n - 1, B);
		return A[k];
	}
	
	
	/*
	 * Basic quickSort algorithm.
	 * 
	 * Return the index of the kth smallest number (lo to hi)
	 * 
	 */
	public static int quickSort(int[] a, int lo, int hi, int k) {

		int i = lo;
		int j = hi;
		int pivot = a[hi];

		while (i < j) {
			if (a[i++] > pivot)
				swap(a, --i, --j);
		}
		swap(a, i, hi);

		// count lower numbers
		int count = i - lo + 1;

		// check if we found the target
		if (count == k) {
			return i;
		}
		// move down the partition to re-count
		else if (count > k) {
			return quickSort(a, lo, i - 1, k);
		}
		// move up the partition to re-count
		else {
			return quickSort(a, i + 1, hi, k - count);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
