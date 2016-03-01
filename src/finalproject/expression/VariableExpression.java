package finalproject.expression;

import finalproject.visitorpattern.Visitor;

/**
 * A variable expression. See {@link AbstractExpression} for more information.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 * @see AbstractExpression
 */
public class VariableExpression extends AbstractExpression {

    /**
     * @param datum is the String of a number
     * @see AbstractExpression#AbstractExpression(AbstractExpression, AbstractExpression, String)
     */
    public VariableExpression(String datum) {
        super(null, null, datum);
    }

    @Override
    public int evaluate() {
        return 6;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
