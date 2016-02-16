package finalproject.util;

import finalproject.expression.Expression;
import finalproject.expression.NumberExpression;

/**
 * TreePrinter helps convert trees to String.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class TreePrinter {
    /**
     * Converts an expression tree to String recursively.
     *
     * @param root is the root of the expression tree
     * @return a String representation of the given expression tree
     */
    public static String stringifyExpressionTree(Expression root) {
        return stringifyExpressionTreeHelper(root, 0);
    }

    private static String stringifyExpressionTreeHelper(Expression root, int level) {
        String returnCache = "";
        if (root != null) {
            returnCache += stringifyExpressionTreeHelper(root.getRight(), level + 1);
            for (int i = 0; i < level; i++) {
                returnCache += "|";
            }
            returnCache += root.getDatum();
            returnCache += "\n";
            returnCache += stringifyExpressionTreeHelper(root.getLeft(), level + 1);
        }
        return returnCache;
    }

    /**
     * Convert an expression tree to infix expression recursively.
     *
     * @param root is the root of the expression tree
     * @return an infix String representation of the given expression tree
     */
    public static String stringifyAsInFix(Expression root) {
        String returnCache = "";
        if (root != null) {
            if (!(root instanceof NumberExpression)) {
                returnCache += "( ";
            }
            returnCache += stringifyAsInFix(root.getLeft());
            returnCache += root.getDatum() + " ";
            returnCache += stringifyAsInFix(root.getRight());
            if (!(root instanceof NumberExpression)) {
                returnCache += ") ";
            }
        }
        return returnCache;
    }
}
