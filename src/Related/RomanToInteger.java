package Related;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger rom = new RomanToInteger();
		System.out.println(rom.romanToInt("MDCCCIV"));
	}

	public int romanToInt(String A) {
		int num = 0;
		A = A.toUpperCase();
		char[] a = new char[A.length()];
		for(int i = 0; i < A.length(); i++) {
			a[i] = A.charAt(i);
		}
		// {X,I,V} 10-1+5
		// xv 10+5
		//xvi 10+5+1
		//xviii 10+5+1+1+1
		//ix -1+10
		//xxiv 10+10-1+5
		//iv -1+5 
		for(int i = 1; i < a.length; i++) {
				if(intValue(a[i]) > intValue(a[i-1])) {
					num = num - intValue(a[i-1]);	
				} else {
					num = num + intValue(a[i-1]); // 0+10 +10 
				}
		} 
		return num + intValue(a[a.length-1]);
	}
	
	private int intValue(char a) {
		if(a == 'I') {
			return 1; }	
		if(a == 'V') {
			return 5;}
		if(a == 'X') {
			return 10;}
		if(a == 'C') {
			return 100;}
		if(a == 'L') {
			return 50;}
		if(a == 'D') {
			return 500;}
		if(a == 'M') {
			return 1000;}
		return 0;
	}
	
	/*private int power(int i) {
		int result = 1;
		while(i > 0) {
			result = result * 10; // 3 1X10, 2 10*10, 1 100*10 
			i--;
		} 
		return result;
	}*/
}
