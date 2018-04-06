package Related;
import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString rev = new ReverseString();
		//rev.reduceSpaceInbetween("My name is");
		System.out.println(rev.reverseWords("          "));
	}

	public String reverseWords(String a) {
		a = a.trim();
		if(a == "" || a.length() == 1) {
			return a;
		}
		String result = "";
		List<String> words = new ArrayList<>();
		String[]A = a.split(" ");
		
		for(int i = 0; i < A.length; i++) { 
			if(A[i].equals("")) {
				continue;
			} else {
				words.add(A[i]);
			}
		}
		for(int index = words.size() - 1; index >= 0; index--) {
			result = result + words.get(index) + " ";
		}
		return result.trim();
	}
}
