package finalproject.application;

import finalproject.util.tests.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the CLI interface.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Abstract Data Types and Problem Solving - Project 2");
        System.out.println("By Benjapol Worakan (5710546577)");

        System.out.println();
        System.out.println("Hit enter twice to or use ctrl-c exit the program.");
        System.out.println();

        List<String> argsList = Arrays.asList(args);
        if (argsList.isEmpty()) {
            run();
        }
    }
    public static void run() {

        System.out.println("Which function?");
        System.out.println(" 1: Expression Evaluation");
        System.out.println(" 2: Visitor Pattern");
        System.out.println(" 3: Symbolic Differentiation");
        System.out.println(" 4: Symbolic Differentiation Simplifier");
        System.out.println(" 5: MIPS Code Generation");
        System.out.println(" 6: Infix to Postfix Conversion");
        System.out.print("Enter your choice (1~6): ");
        String in = scan.nextLine();
        if (in.isEmpty()) {
            System.exit(0);
        }
        char choice = in.charAt(0);
        switch (choice) {
            case '1':
                ExpressionTest.main(null);
                break;
            case '2':
                VisitorPatternTest.main(null);
                break;
            case '3':
                DifferentiationTest.main(null);
                break;
            case '4':
                DifferentiationSimplifierTest.main(null);
                break;
            case '5':
                AssemblyGeneratorTest.main(null);
                break;
            case '6':
                InfixToPostfixTest.main(null);
                break;
            default:
                System.out.println("Incorrect choice! Please try again.");
                run();
        }
    }
}
