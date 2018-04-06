package linkedList;

public class RotateList {

	public static void main(String[] args) {
		RotateList sol = new RotateList();
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next =new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		System.out.println(sol.rotateRight(a, 2));
	}
	public ListNode rotateRight(ListNode a, int b) {
		if(a == null || b == 0) {
			return a;
		}
		if(b < 0) {
			return a;
		}
		ListNode endNode =  a;
		ListNode last =  a;
		int count = 0;
		int size = 0;
		
		while(last != null) {
			last = last.next;
			size++;
		}
		while(count < (size-b)) {
			endNode = endNode.next;
			count++;  // 0<3 1  1<3 2   2<3 3   
		}
		ListNode newStart = endNode;
		ListNode newStartCopy = newStart;
		while(newStart.next != null) {
			newStart = newStart.next; //4 5	
		}
		endNode = null;
		newStart.next = a;
		return newStartCopy;
	}
}
