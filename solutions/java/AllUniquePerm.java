import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AllUniquePerm {

/*
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations. Example : [1,1,2] have the following unique
	 * permutations:
	 * 
	 * [1,1,2] [1,2,1] [2,1,1]
	 * 
	 * [1,1,1] : [1,1,1]
	 * 
	 */

	
	public static void main (String args[]) {
		int[] arr1 = { 1, 1, 2 };
		ArrayList<ArrayList<Integer>> my = permute(fillArrayList(arr1));
		System.out.println("Unique Permutation results:\n" + my);
		
		int[] arr2 = { 1, 1, 1 };
		my = permute(fillArrayList(arr2));
		System.out.println("Unique Permutation results:\n" + my);
		
	}
	
	public static ArrayList<Integer> fillArrayList(int[] arr) {
		int size = arr.length;
		ArrayList<Integer> thisArr = new ArrayList<Integer>();
		
		for (int i = 0; i< size; i++) {
			thisArr.add(arr[i]);
		}
		return thisArr;
	}
	
	
	/*
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations. Example : [1,1,2] have the following unique
	 * permutations:
	 * 
	 * [1,1,2] [1,2,1] [2,1,1]
	 * 
	 * [1,1,1] : [1,1,1]
	 * 
	 */

	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		int MAX_PERMUTATIONS = 128;

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> permutation = new ArrayList<Integer>();

		if (A == null || A.size() == 0) {
			return results;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : A) {
			// Map and initialize only unique elements
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		// Permutations n!
		if (A.size() <= MAX_PERMUTATIONS) {
			traverseAndCreateLists(map, A.size(), permutation, results);
		}
		else {
		    System.out.println("Too many permutations expected. Can't process that.");
		}
		return results;
        
    }
    
    private static void traverseAndCreateLists(Map<Integer, Integer> mapConstruct, int size, ArrayList<Integer> permu,
			ArrayList<ArrayList<Integer>> res) {
		if (size == 0) {
			res.add(new ArrayList<>(permu));
			return;
		}
		for (int key : mapConstruct.keySet()) {
			int value = mapConstruct.get(key);
			
			if (value > 0) {
				mapConstruct.put(key, value - 1);
				permu.add(key);

				traverseAndCreateLists(mapConstruct, size - 1, permu, res);
				// remove processed element from "permu" list
				permu.remove(permu.size() - 1);

				mapConstruct.put(key, mapConstruct.get(key) + 1);
			}
		}
	}

}
