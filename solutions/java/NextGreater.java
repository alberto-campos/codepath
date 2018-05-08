import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Arrays;

public class NextGreater {

	/*
	 * 
	 * Given an array, find the next greater element G[i] for every element A[i] in
	 * the array. The Next greater Element for an element A[i] is the first greater
	 * element on the right side of A[i] in array. Example:
	 * 
	 * Input : A : [4, 5, 2, 10] Output : [5, 10, 10, -1]
	 * 
	 * Example 2:
	 * 
	 * Input : A : [3, 2, 1] Output : [-1, -1, -1]
	 * 
	 */

	public static void main(String args[]) {
		int[] arr1 = { 4, 5, 2, 10 };
		ArrayList<Integer> my = nextGreater(createArrayList(arr1));
		System.out.println("Greatest elements in array:\n" + my);

		int[] arr2 = { 3, 2, 1 };
		my = nextGreater(createArrayList(arr2));
		System.out.println("Greatest elements in array:\n" + my);

	}

	public static int[] initializeArray(int size) {
		int[] thisArr = new int[size];

		for (int i = 0; i < size; i++) {
			thisArr[i] = -1;
		}
		return thisArr;
	}

	public static ArrayList<Integer> createArrayList(int[] arr) {
		int size = arr.length;
		ArrayList<Integer> thisArr = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			thisArr.add(arr[i]);
		}
		return thisArr;
	}

	public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
		int size = A.size();
		int[] nextGrElemsArr = initializeArray(size);

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			int currElement = A.get(i); // initialize with current element

			while (!stack.isEmpty() && currElement > ( A.get(stack.peek()) ) ) {
				// curr elem is now greater; store it in array & push it to stack.
				nextGrElemsArr[stack.pop()] = currElement; 
			}
			stack.push(i);
		}

		return createArrayList(nextGrElemsArr);

	}

}
