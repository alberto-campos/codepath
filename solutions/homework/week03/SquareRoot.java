public class Solution {
	public int sqrt(int a) {
	    if (a == 0 || a == 1) {
            return a;
	    }
 
        long start = 1L; 
        long end = (long)a;
        
        // Binary search
        while (start <= end)
        {
            // overflow control.
            long middle = (start + (end + start) ) / 2L;
 
            // Found a perfect square.
            if (middle*middle == a) {
                return (int)middle;
            }
 
            // divide and conquer to get closer to floor.
            if (middle <= a / middle) {
                start = middle + 1L;
            } 
            else {
                end = middle - 1L;
            }
        }

        return  (int) (start - 1L);
	    
	}
}

