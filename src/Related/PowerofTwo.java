package Related;

import java.math.BigInteger;

public class PowerofTwo {

	public static void main(String[] args) {
		PowerofTwo power = new PowerofTwo();
		System.out.println(power.power("2"));
	}
	
	public int power(String A) {
		BigInteger a = new BigInteger(A); // input number
		while(a.compareTo(new BigInteger("1")) == 1) {
			BigInteger arr[] = a.divideAndRemainder(new BigInteger("2"));
			
			// arr[1] is the reminder after division from 2. If its 1 then the number was odd and can't be a power of 2.
			if(arr[1].compareTo(new BigInteger("1")) == 0) {
				return 0;
			}
			
			// arr[0] is the quotient after division from 2.
			if(arr[0].compareTo(new BigInteger("1")) == 0) {
				if (arr[1].compareTo(new BigInteger("0")) == 0){
					return 1;
				}
				//a = a % 10003;
				return 0;
			}
			
			//a = a % 10003;
			a = arr[0];
		}
		return 0;
	}

}
// 18,446,744,073,709,551,616
// 147,573,952,589,676,412,928 = 2 ^ 67