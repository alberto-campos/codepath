/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        
        ListNode step = A;
        ListNode doubleStep = A;
        
        // Using the slow (one step) fast (double step) method.
        while (doubleStep != null && doubleStep.next != null) {
            step = step.next;
            doubleStep = doubleStep.next.next;
        }
        // middle case. Ignore  a b a  ... will ignore b.
        if (doubleStep != null) {
            step = step.next;
        }
        
        step = reverse(step);
        
        // check for palindrome
        while (step != null) {
            if (step.val != A.val) {
                return 0;
            }
            step = step.next;
            A = A.next;
        }
        
        return 1;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }
        return previous;
    }
}

