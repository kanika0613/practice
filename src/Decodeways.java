
public class Decodeways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numDecodings(String s) { // "12" as AB, L
		s = s.trim();
		if(s == null) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		int[] result = new int[s.length() + 1];
		result[s.length() ] = 1;
		if(s.length()-1 == 0) {
			result[s.length() -1 ] = 0;	
		} else {
			result[s.length() -1 ] = 1;
		}
		for (int ch = s.length() - 2; ch > 0; ch--) {
			if(s.charAt(ch) == 0) {
				continue;
			} else {
				result[ch] = (Integer.parseInt(s.substring(ch,ch+2)) <= 26) ? result[ch+1]+result[ch+2]: result[ch+1];
			}
		}
		return result[0];
	}
}
