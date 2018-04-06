import java.lang.management.ManagementPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctNumberInWindow {

	public static void main(String[] args) {
		DistinctNumberInWindow sol = new DistinctNumberInWindow();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(3);
		ArrayList<Integer> result = sol.dNums(a, 3);
		for(Integer i: result) {
			System.out.println(i);	
		}
	}

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		HashMap<Integer,Integer> map = new HashMap<>(B);
		ArrayList<Integer> result = new ArrayList<>();
		for(int index = 0; index <= A.size() - B; index++) {
			for(int currentWindow = 0; currentWindow < B; currentWindow++) {
				Integer value = A.get(index+currentWindow);
				Integer count = map.get(value);
				if(count == null) {
					map.put(value,1);
				}
				else {
					map.put(value, count + 1);
				}
			}
			result.add(map.keySet().size());
			map.clear();
		}
		return result;
	}
}
