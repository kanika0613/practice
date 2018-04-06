import java.util.ArrayList;
import java.util.List;

public class SeatArrangment {

	public static void main(String[] args) {
		SeatArrangment obj = new SeatArrangment();
		System.out.println(obj.seats("....x..xx..x..x.."));
	}

	//{1,4,7} X positions
	// 4 is median
	// now shift all x towards 4th position
	public int seats(String A) {
		A = A.toLowerCase();
		int jump = 0;
		//System.out.println(A);
		List<Integer> xPositionList = getPositionList(A); // 4, 7, 8, 12
		if(xPositionList.size() == 0) {
			return 0;
		}
		if(xPositionList.size() == 1) {
			return (0 % 10000003);
		}
		int midXPosition = xPositionList.get(xPositionList.size()/2);
		//System.out.println(midXPosition);
		// now shift all X towards mid
		jump = jump + shiftXBeforeMid(midXPosition - 1, 0, A) ;
		jump = jump% 10000003;
		jump = jump + shiftXAfterToMid(midXPosition + 1, A.length() - 1, A);
		return jump % 10000003;
	}

	private int shiftXBeforeMid(int midPrev, int zero, String A) {
		int jumps = 0; 
		for(int fromLeft = zero, fromRight = midPrev; fromLeft <= fromRight;) {
			if(A.charAt(fromRight) == '.') {
				if(A.charAt(fromLeft) == 'x' || A.charAt(fromLeft) == 'X'){
					swap(fromLeft, fromRight, A);
					jumps = jumps + Math.abs(fromRight - fromLeft);
					fromRight--;
					fromLeft++;
				} else {
					fromLeft++;
					continue;
				}
			} else {
				fromRight--;
				continue;
			}
		}
		return jumps% 10000003;
	}
	private int shiftXAfterToMid(int midNext, int last, String A) {
		int jumps = 0; 
		for(int fromLeft = midNext, fromRight = last; fromLeft <= fromRight;) {
			if(A.charAt(fromLeft) == '.') {
				if(A.charAt(fromRight) == 'x' || A.charAt(fromRight) == 'X') {
					swap(fromLeft, fromRight, A);
					jumps = jumps + Math.abs(fromRight - fromLeft);
					fromRight--;
					fromLeft++;
				} else {
					fromRight--;
					continue;
				}
			} else {
				fromLeft++;
				continue;
			}
		}
		return jumps% 10000003;
	}
	private void swap(int availablePosition, int index, String A) {
		char a = A.charAt(availablePosition);
		char b = A.charAt(index);
		char temp  = a;
		a = b;
		b = temp;
	}

	private List<Integer> getPositionList(String A) {
		List<Integer> positionList = new ArrayList<>();
		int i = 0;
		for(int index = 0; index < A.length(); index++) {
			if(A.charAt(index) == 'X' || A.charAt(index) == 'x') {
				positionList.add(index);
				i++;
			}else {
				continue;
			}
		}
		return positionList; // {1,4,7} X positions
	}
}
// .x.. mid ..x.x.