/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
 
 // Note: This question is similar to problem described on  
 // pre-work assignments from Week 3.
 // Using Priority Queue to maintain order.
 
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    if (a == null || a.size() == 0) {
	        return null;
	    }
        
        // Customizing queue to keep track with node's 'weight' 
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode> (a.size(), new Comparator<ListNode>() {
            
            @Override
            public int compare(ListNode o1, ListNode o2){
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode result = new ListNode(0);
        ListNode tail = result;
        
        // traverse linked lists and add to queue.
        for (ListNode node : a) {
            if (node != null) {
                queue.add(node);
            }
        }
            
        // traversing queue.
        while (!queue.isEmpty()) {
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        
        return result.next;
	}
	
    
}

