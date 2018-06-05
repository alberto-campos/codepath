/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
 // Disclaimer: For this homework, 
 // the tutorial from Cracking the code interview 
 // explained a very similar problem.
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = A;
        
        while ( (node != null) || (stack.size() > 0) ) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0 ) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        
     return res;   
    }
}

