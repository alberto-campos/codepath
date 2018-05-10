import java.util.Random;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		if (next != null) {
			return val + " -> " + next;
		} else {
			return val + "";
		}
	}
}

public class SubstractLinkedList {
	
	public static void main (String[] args) {
		subtract(initializeListNode());
	}
	
    public static ListNode subtract(ListNode A) {
    		System.out.println("Original: \t" + A);
		ListNode head = A;
		ListNode slow = head;
		ListNode fast = slow.next;

		// Using the fast-slow pointer strategy: advance "fast" 2 nodes.
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode temp = reverseListUtil(slow.next);
		ListNode modifyInReverse = temp;

		while (head != null && modifyInReverse != null) {
			head.val = modifyInReverse.val - head.val;
			head = head.next;
			modifyInReverse = modifyInReverse.next;
		}
		// fill-in second half
		reverseListUtil(temp);

		System.out.println("Result: \t\t" + A);
		return A;

    }
    

	// Fill up listNode
	// Returns listNode with N random values.
	private static ListNode initializeListNode() {

		Random rand = new Random();
		ListNode result = new ListNode(rand.nextInt(10)+1);
		
		result.next = new ListNode(rand.nextInt(10)+1);
		result.next.next = new ListNode(rand.nextInt(10)+1);
		result.next.next.next = new ListNode(rand.nextInt(10)+1);
		result.next.next.next.next = new ListNode(rand.nextInt(10)+1);
		
		return result;
	}

	// Simple reverseListUtility
	private static ListNode reverseListUtil(ListNode headReference) {

		ListNode prev = null;
		ListNode current = headReference;
		ListNode next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		headReference = prev;
		return headReference;
	}
}

