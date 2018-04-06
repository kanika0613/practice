import java.util.HashMap;

public class PrintCountChar {

	public static void main(String[] args) {
		PrintCountChar ob = new PrintCountChar();
		//System.out.println(ob.getCount("abbaccdbac"));
		ob.print("aaabbkccddhfg");
	}

	private String getCount(String s) {
		char[] ch = s.toCharArray();
		StringBuilder sb  = new StringBuilder();

		HashMap<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < ch.length ; i++) {
			Integer count = 0;
			if(map.isEmpty()) {
				count = 0;
			} else {
				count = map.get(ch[i]) ;
				if(count == null) {
					count = 0;
				}
			}
			map.put(ch[i], count + 1);
		}
		for(Character c : map.keySet()) {
			sb .append(c + "" + map.get(c) + "");
		}
		return sb.toString();	
	}

	private void print(String s) {
		int count = 1;
		for(int i = 1; i < s.length() ; i++) {
			if(s.charAt(i) == s.charAt(i-1)) {
				count = count + 1;
				if(i == s.length() - 1) {
					System.out.print(s.charAt(i-1) +"" + count);
					break;
				}
			} else {
				if(i == s.length() - 1) {
					System.out.print(s.charAt(i-1) +"" + count);
					System.out.print(s.charAt(i) + "" + 1);
					break;
				}
				System.out.print(s.charAt(i-1) + "" + count);
				count = 1;
			}
		}
	}
}
