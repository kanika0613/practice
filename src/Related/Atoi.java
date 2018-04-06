package Related;

public class Atoi {

	public static void main(String[] args) {
		Atoi a = new Atoi();
		System.out.println(a.myAtoi("-123"));
		System.out.println(a.myAtoi("123"));
		System.out.println(a.myAtoi("0123"));
		System.out.println(a.myAtoi("000123"));
		System.out.println(a.myAtoi("+123"));
		System.out.println(a.myAtoi("+123"));
		System.out.println(a.myAtoi("+-0123"));
		System.out.println(a.myAtoi(Integer.MAX_VALUE+ ""));
	}

	public int myAtoi(String str) { // "1234"
		str = str.trim();
		int len= str.length();
		if(len == 0){
			return 0;
		} 
		if(len == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')){
			return 0;
		}
		if(len == 1) {
			return intValue(str.charAt(0));
		}
		
		if(str.charAt(0) == '-' || str.charAt(0) == '+' ) {
			if(str.charAt(1) == '-' || str.charAt(1) == '+' ) {
				return 0;
			}
		}
		int sign  = 1;

		if(str.charAt(0) == '-') {
			sign = -1; 
		}
		else if(str.charAt(0) == '+') {
			sign = 1;
		}
		/*else {
			sign = 1;
		}*/
		int sum  = intValue(str.charAt(len-1));
		int digitCount = 1;
		for(int i = len - 2; i >0 ; i--) {
			if(sum > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(sum < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			sum  = sum + intValue(str.charAt(i)) * power(digitCount);
			digitCount++;
		}
		if (str.charAt(0) == '+' ) {
			return sum;
		} else if (str.charAt(0) == '-'){
			return sum * sign;	
		} else {
			sum = sum + intValue(str.charAt(0)) * power(digitCount);
			return sum;
		}
	}

	private int intValue(char a) {
		if(a == '0') {
			return 0; }	
		if(a == '1') {
			return 1;}
		if(a == '2') {
			return 2;}
		if(a == '3') {
			return 3;}
		if(a == '4') {
			return 4;}
		if(a == '5') {
			return 5;}
		if(a == '6') {
			return 6;}
		if(a == '7') {
			return 7;}
		if(a == '8') {
			return 8;}
		if(a == '9') {
			return 9;}
		return 0;
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
