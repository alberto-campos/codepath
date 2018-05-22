public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0; i < A.size(); i++ ) {
            int target = B - A.get(i);
            if (map.containsKey(target) ) {
                res = map.get(target);
                res.add(i+1);
                map.put(target, res);
                return res;
            }
            else if (!map.containsKey(A.get(i)) ) {
                // reset recent
                ArrayList<Integer> mostRecent = new ArrayList<Integer>();
                mostRecent.add(i+1);
                map.put(A.get(i), mostRecent);
                
            }
        }
        return res;
        
    }
}

