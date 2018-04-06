package lru;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	LinkedHashMap<Integer, Integer> map; 
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<Integer,Integer>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
				//System.out.println("In my remove Eldest function " + eldest.getKey());
		        return map.size() > capacity;
		     }
		};
	}

	public int get(int key) {
		Integer val = map.get(key);
		if(val == null) {
			return -1;
		} else {
			map.remove(key);
			map.put(key, val);	
			return val;
		}
	}

	public void put(int key, int value) {
		map.remove(key);
		map.put(key, value);
	}
	
	
	public static void main(String[] args) {
		LRUCache lr = new LRUCache(2);
		lr.put(1, 1);
		lr.put(2, 2);
		System.out.println(lr.get(1));
		lr.put(3, 3);
		System.out.println(lr.get(2));
		lr.put(4, 4);
		System.out.println(lr.get(1));
		System.out.println(lr.get(3));
		System.out.println(lr.get(4));
		}
}
