public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        
            int i = 0;
            int j = 1;
            Collections.sort(A);
            
            while ((i < A.size()) && j < A.size() ) {
                int diff = A.get(j) - A.get(i);
                if (diff == B && i != j) {
                    return 1;
                }
                else if (diff < B) {
                    j++;
                }
                else {
                    i++;
                }
            }
         return 0;   
        
    }
}

