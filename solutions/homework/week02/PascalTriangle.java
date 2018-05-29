public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int A) {
        // To generate A[C] in row R, 
        // sum up A p[C] and  A p[C-1] from previous row R - 1.
        // A[C] = 
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> previousRow = new ArrayList<Integer>();
        previousRow.add(1); // initialize
        res.add(previousRow);
        
        
        for (int i = 1; i < A; i++) {
            ArrayList<Integer> rows = new ArrayList<Integer>();
            rows.add(1);
            
            for (int C = 1; C < previousRow.size(); C++) {
                // summ up previous and previous-1
                rows.add(previousRow.get(C) + previousRow.get(C-1));
                //if (j == i) {
                    //res.get(i).add(Array.asList());
                //}
            }
            rows.add(1);  // finalize
            res.add(rows);
            previousRow = rows;
        }
        return res;
    }
}

