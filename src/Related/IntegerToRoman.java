package Related;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman rom = new IntegerToRoman();
		int [] A = new int[]{2,2,3};
		System.out.println(rom.intToRoman(A));
	}
	public String intToRoman(int[] A) {
		String num = "";
		int	digitCount = 0;
		for(int i = A.length - 1; i >= 0;  i--) {
			num = num + getRomanValue((A[i] * power(digitCount)), digitCount) + "";
			digitCount++;
		}
		ReverseWord rev = new ReverseWord();
		return rev.reverseWords(num);
	}

	private String getRomanValue(int a, int digitCount) {
		String result= "";
		if(digitCount == 0) {
			return getValue(a);
		} else {
			int digit = a/power(digitCount);
			//digit times of 10*digitCount
			String temp = getValue(power(digitCount));
			while(digit > 0) {
				result = result + temp;
				digit--;
			}
			return temp;
		}
	}
	private String getValue(int a){
		if(a == 1) {
			return "I"; }
		if(a == 2) {
			return "II"; }
		if(a == 3) {
			return "III"; }
		if(a == 4) {
			return "IV"; }
		if(a == 5) {
			return "V";}
		if(a == 6) {
			return "VI"; }
		if(a == 7) {
			return "VII"; }
		if(a == 8) {
			return "VIII"; }
		if(a == 9) {
			return "IX"; }
		if(a == 10) {
			return "X";}
		if(a == 100) {
			return "C";}
		if(a == 50) {
			return "L";}
		if(a == 500) {
			return "D";}
		if(a == 1000) {
			return "M";}
		return "";
	}

	private int power(int i) {
		int result = 1;
		while(i > 0) {
			result = result * 10; // 3 1X10, 2 10*10, 1 100*10 
			i--;
		} 
		return result;
	}
}
