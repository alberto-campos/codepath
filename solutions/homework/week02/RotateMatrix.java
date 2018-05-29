public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    if ( (a == null) || (a.size() == 0) ) {
            return;
        }
        else {
            int size = a.size();
            int topleft, bottomright;

            // rotate clockwise
            for(int i = 0; i < (size/2); i++) {
                topleft = i;
                bottomright = size - i - 1;

                // Transpose matrix and swap rows.
                for(int j = topleft; j < bottomright; j++){
                    int offset = j-i;
                    int top = a.get(topleft).get(j);
                                   
                    a.get(topleft).set(j, a.get(bottomright - offset).get(topleft)); 
                    a.get(bottomright-offset).set(topleft, a.get(bottomright).get(bottomright - offset));
                    a.get(bottomright).set(bottomright - offset, a.get(j).get(bottomright));
                    a.get(j).set(bottomright, top);
                }
            }
        }
	
	}
}

