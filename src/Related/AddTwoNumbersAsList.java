package Related;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersAsList {

	public static void main(String[] args) {
		AddTwoNumbersAsList obj = new AddTwoNumbersAsList();
		ListNode a = new ListNode(0);
		//a.next = new ListNode(9);
		
		ListNode b = new ListNode(1);
		b.next = new ListNode(0);
		b.next.next = new ListNode(1);
		//b.next.next.next = new ListNode(1);
		
			List<Integer> result = obj.addTwoNumbers(a,b);
			for(int item = result.size() - 1; item >= 0; item--) {
				System.out.print(result.get(item) +"");
			}
	}
	public List<Integer> addTwoNumbers(ListNode a, ListNode b) {
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
	private static List<Integer> addList(List<Integer> aList, List<Integer> bList) {
		List<Integer> result = new ArrayList<>();
		int sum = 0;
		int  i , j;
		int carry = 0;
		for(i = 0, j = 0; (i <= aList.size() - 1  && j <= bList.size() - 1 ); i++, j++) {
			sum = aList.get(i) + bList.get(j) + carry;
			if(istwodigit(sum)) {
				if(i == aList.size() - 1) {
					result.add(sum % 10);
					carry  = sum / 10;
				} else {
					result.add(sum % 10);
					carry = sum / 10;
				}
			} else {
				result.add(sum); // if single digit sum
			}
		}
		while(i < aList.size()) {
			if(istwodigit(aList.get(i) + carry)) {
				result.add((aList.get(i) + carry) %10);
				carry = (aList.get(i) + carry) /10;
			} else {
				result.add(aList.get(i) + carry);
				carry = 0;
			}
			i++;
		}
		while(j < bList.size()) {
			if(istwodigit(bList.get(i) + carry)) {
				result.add((bList.get(i) + carry) %10);
				carry = (bList.get(i) + carry) /10;
			} else {
				result.add(bList.get(i) + carry);
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
