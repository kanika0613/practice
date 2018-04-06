import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		ValidParanthesis valid = new ValidParanthesis();
		System.out.println(valid.isValid("(("));
	}

	public boolean isValid(String s) {
		if(s == null) {
			return true;
		}
		if(s.length() == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < s.length() ; i++) {
			char input = s.charAt(i);
			if(isOpeningBracket(input)) {
				stack.push(input);
			} 
			else {
				if(!stack.empty() && isValidClosing(stack.peek(), input)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	private boolean isValidClosing(char top, char input) {
		if(input == ')' && top == '(') {
			return true;
		}
		if(input == ']' && top == '[') {
			return true;
		}
		if(input == '}' && top == '{') {
			return true;
		}
		return false;
	}

	private boolean isOpeningBracket(char ch) {
		if(ch == '(' || ch == '{' || ch == '[')
			return true;
		else 
			return false;
	}
	/*private boolean isValidString(char ch) {
		if(ch == '(' || ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}') {
			return true;
		}
		return false;
	}*/

}
