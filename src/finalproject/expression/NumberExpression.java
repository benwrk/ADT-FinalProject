package finalproject.expression;

import finalproject.visitorpattern.Visitor;

public class NumberExpression extends Expression {

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
