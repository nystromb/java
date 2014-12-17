import java.util.Stack;
import java.util.StringTokenizer;


public class EvaluatePostFix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(evaluatePostfix(args[0]));
	}
	
	public static Integer evaluatePostfix(String postfix){
		StringTokenizer str = new StringTokenizer(postfix);
		Stack<Integer> valueStack = new Stack<Integer>();
		for(int i = 0; i < str.countTokens(); i++){
			char nextCharacter = str.nextToken().charAt(0);
			if(nextCharacter == ' ' || nextCharacter == '\'')
				continue;
			else{
			switch(nextCharacter){
			case '+' : case '-' : case '*' : case '/' : case '^' : 
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();
				int result = 0;
				
				if(nextCharacter == '+')
					result = operandOne + operandTwo;
				else if(nextCharacter == '-')
					result = operandOne - operandTwo;
				else if(nextCharacter == '*')
					result = operandOne * operandTwo;
				else if(nextCharacter == '/')
					result = operandOne / operandTwo;
				else if(nextCharacter == '^')
					result = (int) Math.pow(operandOne, operandTwo);
				
				valueStack.push(result);
			default : valueStack.push((Integer.parseInt(str.nextToken()))); 
			}
			}
			}
		return valueStack.peek();
	}
}
