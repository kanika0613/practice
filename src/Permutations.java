import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int element = 0; element < nums.length; element++) {
			int count = 0;
			if(map.get(nums[element]) == null) {
				map.put(nums[element], count);
			}
			map.put(nums[element], count + 1);
		}

		int[] count = new int[nums.length];
		int level = 0;
		int  i= 0;
		for(Integer value: map.values()) {
			count[i] = value;
			i++;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		
	}
	public void findPermutations(int [] count, int nums, ArrayList<ArrayList<Integer>> result){

		return;
	}

}
