package finalproject.expression;

import finalproject.visitorpattern.Visitor;

/**
 * A multiplication expression. See {@link AbstractExpression} for more information.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 * @see AbstractExpression
 */
public class MultiplicationExpression extends AbstractExpression {

    /**
     * @param left  is the left operand
     * @param right is the right operand
     * @see AbstractExpression#AbstractExpression(AbstractExpression, AbstractExpression, String)
     */
    public MultiplicationExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right, "*");
    }

    @Override
    public int evaluate() {
//        System.out.println(getLeft().evaluate() + " " + getDatum() + " " + getRight().evaluate() + " = " + (getLeft().evaluate() * getRight().evaluate()));
        return getLeft().evaluate() * getRight().evaluate();
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }


}
