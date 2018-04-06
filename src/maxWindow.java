
public class maxWindow {

	public static void main(String[] args) {
		maxWindow ob = new maxWindow();
		int a[] = new int[] {7,2,4};
		int[] r = ob.maxSlidingWindow(a,2);
		for(int i = 0;i < r.length;i++)
			System.out.println(r[i]);	
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null) {
			return new int[] {};
		}
		if( k == 0) {
			return nums;
		}
		if(k == 1) {
			return nums;
		}
		if(k <= nums.length) {
			int max =  Integer.MIN_VALUE;
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] > max) {
					max = Math.max(nums[i], max);
				}	
			}
			return new int [] {max};
		}
		int[] result = new int[nums.length -1];
		int i = 0;
		while(i < result.length) {	
			int max =  Integer.MIN_VALUE;
			for(int j = i; j < i+k; j++) {
				if(nums[j] > max) {
					max = Math.max(nums[j], max);
				}
			}
			result[i] = max;
			i++;
		}
		return result;
	}
}
