
public class KeyPad {

	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9},{'*',0,'#'}};
		KeyPad ob = new KeyPad();
		String num = "*3#**";
		System.out.println(ob.key(a,num));
	}

	int key(int[][]a , String num) {
		int count = 0;
		int[] one = new int[2];
		int[] two = new int[2];
		for(int i = 1; i < num.length(); i++) {
			one = getPos(num.charAt(i-1), a[0].length);
			two = getPos(num.charAt(i), a[0].length);
			count += Math.abs(one[0] - two[0]) + Math.abs(one[1] - two[1]);
		}
		return count;
	}
	
	int[] getPos(char ch, int length) {
		int[] result = new int[2];
		if(ch == '0') {
			result[0] = 3;
			result[1] = 1;
		} else if(ch == '#') {
			result[0] = 3;
			result[1] = 2;
		} else if(ch == '*') {
			result[0] = 3;
			result[1] = 0;
		} else {
			result[0] = Character.getNumericValue(ch) / length ;
			result[1] = Character.getNumericValue(ch) % length - 1;
		}
		return result;
	}
}
