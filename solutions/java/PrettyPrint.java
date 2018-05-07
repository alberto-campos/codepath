/*
 * Print concentric rectangular pattern in a 2d matrix. 
 * 
 *
 * Input: A = 4.
		Output:
		
		4 4 4 4 4 4 4 
		4 3 3 3 3 3 4 
		4 3 2 2 2 3 4 
		4 3 2 1 2 3 4 
		4 3 2 2 2 3 4 
		4 3 3 3 3 3 4 
		4 4 4 4 4 4 4 
 * 
 */

public class Solution {
    
    public int[][] prettyPrint(int A) {
        
        int size = getMatrixSize(A);
        int[][] res = new int[size][size];
        
        if (A > 0) {
            res = printFrame(A);   
        } 
    	else {
    		
    		System.out.println("Your matrix size is: " + A + ". Perhaps it's not valid.");
    	}
        return res;
    }

    private static int[][] printFrame(int nums) {
    	// array size = A(n) = 1 + (n-1)*2
    	int end = getMatrixSize(nums);
    	int start = 0;
    	int[][] res = new int[end][end];;
    
    	for (int i = start; i < end; i++) {
    		for (int j = start; j < end; j++) {
    			int n = 0;
    
    			while (n <= nums) {
    				if (i == start + n || j == start + n || i == end - 1 - n || j == end - 1 - n) {
    					//System.out.print((nums - n) + " \b ");
    					res[i][j] = nums - n;
    					break;
    				}
    				n++;
    			}
    		}
    		//System.out.println();
    
    	}
    	return res;
        
    }

private static int getMatrixSize(int n) {
	int MAX_SIZE = 128;
	int i = -1;
	if (n < MAX_SIZE) {
		// spiral sequence math formula.
		i = 1 + (n - 1) * 2;
	} else {
		System.out.println("That might cause overflow. Returning -1.");
		i = -1;
	}
	return i;
}
    
    
}
