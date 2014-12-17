import java.util.Stack;

public class ConvertPostfix {
	
	public static int precedence(char operator){
		int precedence = 0;
		
		if(operator == '(' || operator == ')')
			precedence = 0;
		else if(operator == '+' || operator == '-')
			precedence = 1;
		else if(operator == '*' || operator == '/')
			precedence = 2;
		else if(operator == '^')
			precedence = 3;
		
		return precedence;
	}
	
public static String convertToPostfix(String infix){
	Stack<Character> operatorStack = new Stack<Character>();
	String postfix = "";
		
	for(int i = 0; i < infix.length(); i++){
		char nextCharacter = infix.charAt(i);
		if(nextCharacter== ' ' || nextCharacter == '\'')
			continue;
		else{
		switch(nextCharacter) {
		case '^' :
			operatorStack.push(nextCharacter);
			break;
		case '+' : case '-' : case '*' : case '/' :
			while(!operatorStack.empty() && precedence(nextCharacter) <= precedence(operatorStack.peek())){
				postfix = postfix + operatorStack.peek();
				operatorStack.pop();
			}
			operatorStack.push(nextCharacter);
			break;
		case '(' :
			operatorStack.push(nextCharacter);
			break;
		case ')' : // stack is not empty if infix expression is valid
			char topOperator = operatorStack.pop();
			while(topOperator != '(') {
				postfix = postfix + topOperator;
				topOperator = operatorStack.pop();
			}
			break;
			default: 
				postfix = postfix + nextCharacter; 
				break;
		}
		}
	}
		
	while (!operatorStack.empty()) {
		char topOperator = operatorStack.pop();
		postfix = postfix + topOperator;
	}
	return postfix;
}
public static void main(String[] args){
	
	System.out.println(convertToPostfix(args[0]));
}
}
