/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if ((A == null) && (B == null)) {
            return null;
        }
        
        ListNode result = new ListNode(-1);
        ListNode start = result;
        while ((A != null) && (B != null) ) {
            if (A.val < B.val) {
                start.next = A;
                A = A.next;
            }
            else {
                start.next = B;
                B = B.next;
            }
            start = start.next;
        }
        if (A != null) {
            start.next = A;
        }
        else {
            start.next = B;
        }
        
        return result.next;
    }
    
}

