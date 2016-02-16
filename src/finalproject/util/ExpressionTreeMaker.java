package finalproject.util;

import finalproject.collection.ListStack;
import finalproject.collection.Stack;
import finalproject.expression.*;

/**
 * Expression Tree maker that can create an expression tree from either infix or postfix expression.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class ExpressionTreeMaker {
    /**
     * Make an expression tree from a postfix expression.
     *
     * @param postfix is a postfix expression that will be used to create the tree
     * @return an expression tree that is created from the given expression
     */
    public static Expression makeWithPostFix(String postfix) {
        Stack<Expression> expressionStack = new ListStack<>();
        String operators = "+-*/";
        String numbers = "0123456789";
        String variables = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : postfix.toCharArray()) {
            if (operators.contains(Character.toString(c))) {
                Expression right = expressionStack.pop();
                Expression operator = null;
                switch (c) {
                    case '+':
                        operator = new AdditionExpression(expressionStack.pop(), right);
                        break;
                    case '-':
                        operator = new SubtractionExpression(expressionStack.pop(), right);
                        break;
                    case '*':
                        operator = new MultiplicationExpression(expressionStack.pop(), right);
                        break;
                    case '/':
                        operator = new DivisionExpression(expressionStack.pop(), right);
                        break;
                }
                expressionStack.push(operator);
            } else if (numbers.contains(Character.toString(c))) {
                expressionStack.push(new NumberExpression(Character.toString(c)));
            } else if (variables.contains(Character.toString(c))) {
                expressionStack.push(new VariableExpression(Character.toString(c)));
            }
        }
        return expressionStack.pop();
    }

    /**
     * Make an expression tree from an infix expression.
     *
     * @param infix is an infix expression that will be used to create the tree
     * @return an expression tree that is created from the given expression
     */
    public static Expression makeWithInFix(String infix) {
        return makeWithPostFix(convertInFixToPostFix(infix));
    }

    /**
     * Convert infix expression to postfix expression.
     *
     * @param infix an infix expression to be converted
     * @return a postfix expression that is the result of the conversion
     */
    public static String convertInFixToPostFix(String infix) {
        Stack<Character> conversionStack = new ListStack<>();
        String postfix = "";
        String operators = "+-*/";
        String lowPrecedenceOperators = "+-";
        String highPrecedenceOperators = "*/";
        String operands = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : infix.toCharArray()) {
            if (operands.contains(Character.toString(c))) {
                postfix += c + " ";
            } else if (c == '(') {
                conversionStack.push(c);
            } else if (operators.contains(Character.toString(c))) {
                if (lowPrecedenceOperators.contains(Character.toString(c))) {
                    while (!conversionStack.isEmpty() && conversionStack.peek() != '(') {
                        postfix += conversionStack.pop() + " ";
                    }
                    conversionStack.push(c);
                } else if (highPrecedenceOperators.contains(Character.toString(c))) {
                    while (!conversionStack.isEmpty() && highPrecedenceOperators.contains(Character.toString(conversionStack.peek())) && conversionStack.peek() != '(') {
                        postfix += conversionStack.pop() + " ";
                    }
                    conversionStack.push(c);
                }
            } else if (c == ')') {
                while (!conversionStack.isEmpty() && conversionStack.peek() != '(') {
                    postfix += conversionStack.pop() + " ";
                }
                conversionStack.pop();
            }
        }
        while (!conversionStack.isEmpty()) {
            postfix += conversionStack.pop() + " ";
        }
        return postfix;
    }
}
