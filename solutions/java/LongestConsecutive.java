import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
		Example:
		Given [100, 4, 200, 1, 3, 2],
		The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 */

public class LongestConsecutive {
	public static void main (String[] args) {
		int[] arr1 = { 100, 4, 200, 1, 3, 2 };
		int[] arr2 = { 63, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 62, 52, 59 };
		
		
		System.out.println("Longest consecutive sequence:" + printLongestSequence(fillArrayList(arr1)));
		
		System.out.println("Longest consecutive sequence:" + printLongestSequence(fillArrayList(arr2)));
		
	}
	
	public static ArrayList<Integer> fillArrayList(int[] arr) {
		int size = arr.length;
		ArrayList<Integer> thisArr = new ArrayList<Integer>();
		
		for (int i = 0; i< size; i++) {
			thisArr.add(arr[i]);
		}
		return thisArr;
	}
	
	public static int printLongestSequence(final List<Integer> A) {
		int longest = 0;
		int length = 0;
		
		// Moving List to a Set so we have O(1) access while traversing List 
		// (without this solution was timing out.)
		Set<Integer> aSet = new HashSet<Integer>();
        for (int num : A) {
            aSet.add(num);
        }

		for (int num : aSet) {
			// Look back one to make sure we not part of a streak count.
			if (!aSet.contains(num - 1)) {
				int target = num;
				length = 1;
				while (aSet.contains(target + 1)) {
					target++;
					length++;
				}
			}
			// we are NOT counting. Recalculate...
			longest = Math.max(length, longest);
		}
		return longest;
	}
	
}
