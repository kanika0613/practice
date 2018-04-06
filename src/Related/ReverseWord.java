package Related;

public class ReverseWord {

	public static void main(String[] args) {
		ReverseWord rev  = new ReverseWord();
		System.out.println(rev.reverseWords("kanika"));
	}

	public String reverseWords(String a) {
		if(a == null) {
			return a;
		}
		a = a.trim();
		String word = "";
		for(int i = a.length() - 1; i >= 0; i--) {
			word = word + a.charAt(i) + "";	
		}
		return word;
	}
}
