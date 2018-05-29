public class Solution {
	public String reverseWords(String a) {
	    a = a.replaceAll(" +", " ");
	    String[] arrStr = a.split("\\s");
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = (arrStr.length - 1); i >= 0; i--) {
	        sb.append(arrStr[i] + " "); 
	    }
	    return sb.toString().trim();
	}
}

