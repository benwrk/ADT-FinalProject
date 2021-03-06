package finalproject.expression;

import finalproject.visitorpattern.Visitor;

/**
 * A representation of Mathematical Expression, for the purpose of evaluation.
 * This class is to be used as the Tree abstract data type.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public abstract class AbstractExpression {
    /**
     * Datum of the Expression.
     */
    private String datum;
    /**
     * Left or right sub-Expression of this Expression.
     */
    private AbstractExpression left, right;

    /**
     * Construct a new Expression.
     *
     * @param left  is the left operand
     * @param right is the right operand
     * @param datum is the Expression represented in String
     */
    public AbstractExpression(AbstractExpression left, AbstractExpression right, String datum) {
        this.datum = datum;
        this.left = left;
        this.right = right;
    }

    /**
     * Get the datum of this Expression.
     *
     * @return datum of this Expression
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Evaluate this Expression to find its value.
     *
     * @return value of the evaluation of this Expression
     */
    public abstract int evaluate();

    /**
     * Get the left operand of this Expression.
     *
     * @return left operand of this Expression
     */
    public AbstractExpression getLeft() {
        return left;
    }

    /**
     * Get the right operand of this Expression.
     *
     * @return right operand of this Expression
     */
    public AbstractExpression getRight() {
        return right;
    }

    public abstract <T> T accept(Visitor<T> v);
}
