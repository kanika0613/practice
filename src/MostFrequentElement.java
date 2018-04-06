import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class MostFrequentElement {

	public static void main(String[] args) {
		MostFrequentElement ob = new MostFrequentElement();
		ob.getMostFrequentElement(new int[] {2,3,1,3,4,2,4,5,6,2,3});
	}

	private int[] getMostFrequentElement(int[] a) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ; i < a.length ; i++) {
			Integer count = 0;
			if(map.containsKey(a[i])) {
				count = map.get(a[i]);
			}
			if(count == null) {
				count = 0;
			}
			map.put(a[i], count+1);
		}
		
		Set<Entry<Integer,Integer>> set = new HashSet<>();
		
		set = map.entrySet();
		Integer max = 1;
		Integer mostFrequestKey = null;
		for(Entry<Integer,Integer> entry : set) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				mostFrequestKey = entry.getKey();
			}
		}
		if(mostFrequestKey == null) {
			return null;
		}
		for(int i = 0; i< a.length; i++) {
			if(a[i] == mostFrequestKey) {
				a[i] = 10000000;
			}
		}
	return a;	
	}
}
