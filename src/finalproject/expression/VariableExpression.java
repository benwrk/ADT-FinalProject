package finalproject.expression;

import finalproject.visitorpattern.Visitor;

public class VariableExpression extends Expression {

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
