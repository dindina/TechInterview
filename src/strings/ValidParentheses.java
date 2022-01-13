package strings;

import java.util.Stack;


public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses("({{}}[])"));

    }

    private static boolean validParentheses(final String str) {

        if(str.length() %2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();

        for( char ch : str.toCharArray())
        {
            if(ch == '{' || ch =='[' || ch =='(')
            {
                stack.push(ch);
            }
            else if(ch == '}' && stack.peek() == '{' ){
                stack.pop();
            }
            else if(ch == ')' && stack.peek() == '(' ){
                stack.pop();
            }
            else if(ch == ']' && stack.peek() == '[' ){
                stack.pop();
            }
        }
        return stack.isEmpty();

        // logic . if the char is opening braces push the stack
        // if the char is closing braces . check the top pf the stack if it has the corresponding
        //opening braces . if yes pop it . finally return true of stack size if empty.


    }
}
