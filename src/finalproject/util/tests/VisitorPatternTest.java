package finalproject.util.tests;

import finalproject.application.Main;
import finalproject.expression.*;
import finalproject.util.ExpressionTreeMaker;
import finalproject.util.TreePrinter;
import finalproject.visitorpattern.Evaluator;

import java.util.Scanner;

/**
 * A test for Visitor Pattern.
 */
public class VisitorPatternTest {
    public static void main(String[] args) {
        Scanner scan = Main.scan;
        System.out.print("Postfix input mode? (Infix otherwise.) (Y/N): ");
        boolean p = scan.nextLine().equalsIgnoreCase("Y");
        String in;
        do {
            System.out.println("=====================");
            System.out.print((p ? "Postfix" : "Infix") + " Input: ");
            in = scan.nextLine();
            if (in.isEmpty()) {
                break;
            }
            System.out.println("Creating expression tree using: " + (p ? in : ExpressionTreeMaker.convertInFixToPostFix(in)));
            AbstractExpression expression = p ? ExpressionTreeMaker.makeWithPostFix(in) : ExpressionTreeMaker.makeWithInFix(in);
            System.out.println("The tree is: ");
            System.out.println(TreePrinter.stringifyExpressionTree(expression));
            System.out.println("Evaluation result: " + new Evaluator().visit(expression));
        } while (!in.isEmpty());
    }
}
