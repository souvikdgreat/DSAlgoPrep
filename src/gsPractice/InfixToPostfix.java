package gsPractice;


import java.util.Stack;
import java.util.Stack;

import java.util.Stack;

public class InfixToPostfix {
    // Function to return the precedence of operators
    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Function to convert infix expression to postfix
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            // If the character is an operand, append it to the result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is an opening parenthesis, push it onto the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is a closing parenthesis
            else if (c == ')') {
                // Pop operators from the stack and append them to the result until a matching opening parenthesis is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop the '(' from the stack
            }
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators from the stack and append them to the result
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String infixExpression = "(c*b)+a";
        String postfixExpression = infixToPostfix(infixExpression);

        System.out.println("Postfix expression: " + postfixExpression);
    }
}
