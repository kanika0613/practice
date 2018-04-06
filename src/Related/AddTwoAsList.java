package Related;

import java.util.ArrayList;
import java.util.List;

public class AddTwoAsList {

	public static void main(String[] args) {
		AddTwoAsList obj = new AddTwoAsList();
		ListNode a = new ListNode(9);
		a.next = new ListNode(9);
		a.next.next = new ListNode(1);
		ListNode b = new ListNode(1);
		obj.addTwoNumbers(a, b);
	}

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode aIndex = a;
		ListNode bIndex = b;
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		while(aIndex != null) {
			aList.add(aIndex.value);
			aIndex = aIndex.next;
		}
		while(bIndex != null) {
			bList.add(bIndex.value);
			bIndex = bIndex.next;
		}
		return addList(aList,bList);
	}
	private ListNode addList(List<Integer> aList, List<Integer> bList) {
		ListNode result = null;
		int sum = 0;
		int  i , j;
		int carry = 0;
		for(i = 0, j = 0; (i <= aList.size() - 1  && j <= bList.size() - 1 ); i++, j++) {
			sum = aList.get(i) + bList.get(j) + carry;
			if(istwodigit(sum)) {
				if(i == 0) {
					if(result == null) {
						result = new ListNode(sum % 10);
						carry  = sum / 10;
					} else {
						result.next = new ListNode(sum % 10);
						carry  = sum / 10;
					}
				} else {
					result.next = new ListNode(sum % 10);
					carry = sum / 10;
				}
			} else {
				result.next = new ListNode(sum); // if single digit sum
			}
		}
		while(i < aList.size() ) {
			if(istwodigit(aList.get(i) + carry)) {
				result.next = new ListNode((aList.get(i) + carry) %10);
				carry = (aList.get(i) + carry) /10;
			} else {
				result.next = new ListNode(aList.get(i) + carry);
				carry = 0;
			}
			i++;
		}
		while(j < bList.size()) {
			if(istwodigit(bList.get(i) + carry)) {
				result.next = new ListNode((bList.get(i) + carry) %10);
				carry = (bList.get(i) + carry) /10;
			} else {
				result.next = new ListNode(bList.get(i) + carry);
				carry = 0;
			}
			j++;
		}
		return result;
	}
	private static boolean istwodigit(int sum) {
		if(sum > 9 && sum < 100) {
			return true;
		} else {
			return false;
		}
	}
}


// abcdefg
// put in stack and pop all
// linked list circle quetsion
//