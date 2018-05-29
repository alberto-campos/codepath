public class Solution {
    public String addBinary(String A, String B) {
        int max = Math.max(A.length(), B.length());
        
        int lenA = A.length();
        int lenB = B.length();
        int i = 0, carry = 0;
        String res = "";
        
        while ( (i < max) || (carry != 0) ) {
            int x = (i < lenA)? Character.getNumericValue(A.charAt(lenA - 1 - i)) : 0;
            int y = (i < lenB)? Character.getNumericValue(B.charAt(lenB - 1 - i)) : 0;
            res = (x + y + carry) % 2 + res;
            carry = (x + y + carry) / 2; 
            i++;
        }
        
        return res;
        
    }
}

