package finalproject.util.tests;

import finalproject.application.Main;
import finalproject.util.ExpressionTreeMaker;

import java.util.Scanner;

/**
 * A test for infix -> postfix conversion.
 */
public class InfixToPostfixTest {
    public static void main(String[] args) {
        Scanner scan = Main.scan;
        String in;
        do {
            System.out.println("=====================");
            System.out.print("Input infix: ");
            in = scan.nextLine();
            if (in.isEmpty()) {
                break;
            }
            System.out.println("Postfix is \"" + ExpressionTreeMaker.convertInFixToPostFix(in) + "\"");
        } while (!in.isEmpty());
    }
}
