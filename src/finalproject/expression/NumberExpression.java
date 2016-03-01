package finalproject.expression;

import finalproject.visitorpattern.Visitor;

/**
 * A number expression. See {@link AbstractExpression} for more information.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 * @see AbstractExpression
 */
public class NumberExpression extends AbstractExpression {

    /**
     * @param datum is the String of a number
     * @see AbstractExpression#AbstractExpression(AbstractExpression, AbstractExpression, String)
     */
    public NumberExpression(String datum) {
        super(null, null, datum);
    }

    @Override
    public int evaluate() {
        return Integer.parseInt(getDatum());
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
