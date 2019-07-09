//Scan both lists
//For each list once it reaches the end, continue scanning the other list
//Once the two runner equal to each other, return the position
//Time O(n+m), space O(1)

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if( null==headA || null==headB )
			return null;

		ListNode curA = headA, curB = headB;
		while( curA!=curB){
			curA = (curA==null) ? headB : curA.next;
			curB = (curB==null) ? headA : curB.next;
		}
		return curA;
    }
