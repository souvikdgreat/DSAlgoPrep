package gsPractice;

import java.util.Stack;

public class InfixToPrefix {
    /*
     *   reverse the infix
     *   convert to postfix
     *    reverse the postfix
     * */
    public static void main(String[] args) {
        String expression = "a+(b*c)";
        StringBuilder replacedExpression = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                ch = ')';
                replacedExpression.append(ch);
                continue;
            }
            if (ch == ')') {
                ch = '(';
            }
            replacedExpression.append(ch);
        }
        StringBuilder reversedExpression = new StringBuilder(replacedExpression).reverse();
        StringBuilder postFix = new StringBuilder(infixToPostfix(reversedExpression.toString()));
        System.out.println(postFix.reverse());
    }


    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static int getPrecedence(char ch) {
        int precedence = 0;
        switch (ch) {
            case '*':
            case '/':
                precedence = 2;
                break;
            case '+':
            case '-':
                precedence = 1;
            default:
        }
        return precedence;
    }


}
