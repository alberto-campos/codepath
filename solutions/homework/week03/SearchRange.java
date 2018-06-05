public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
        
        int start = 0;
        int end = a.size() - 1;
        int mid = 0;
        int rStart = -1;
        
        // binary search
        while(start < end){
            mid = start +  (end - start) / 2;            
            if(b > a.get(mid)){
                start = mid + 1;
            }
            else
                end = mid;
        }
        // setting low index
        int low;
        //Check target not found
        if(b != a.get(start)){
            res.add(-1);
            res.add(-1);
            return res;
        }
        else 
            low = start;
        
        start = 0;
        end = a.size() -1;
        while(start < end){
            mid = start + (end - start)/2;
            if(a.get(mid) < b + 1)
                start = mid + 1;
            else
                end = mid;
        }
        
        // finding high index
        int high = 0;
        if(a.get(start) == b)
            high = start;
        else
            high = start - 1;
        res.add(low);
        res.add(high);
        return res;
	    
	}
}

