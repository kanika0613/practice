import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestNumber {

	public static void main(String[] args) {
		int[] a  = new int[] {2,4,22,1,15,16};
		kthSmallestNumber sol = new kthSmallestNumber();
		System.out.println(sol.kthLargest(a, 1));
	}

	int kthLargest(int[] nums, int k) {
		if (nums.length == 0) {
			return -1;
		}
		if (k > nums.length) {
			return -1;
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for (int index=0; index< nums.length; index++) {
			heap.offer(nums[index]);
		}
		for (int index=0; index < k-1; index++) {
			heap.poll();
		}
		return heap.poll();
	}
	
}
