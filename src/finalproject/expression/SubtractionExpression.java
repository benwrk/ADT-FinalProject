package finalproject.expression;

import finalproject.visitorpattern.Visitor;

public class SubtractionExpression extends Expression {

    public SubtractionExpression(Expression left, Expression right) {
        super(left, right, "-");
    }

    @Override
    public int evaluate() {
//        System.out.println(getLeft().evaluate() + " " + getDatum() + " " + getRight().evaluate() + " = " + (getLeft().evaluate() - getRight().evaluate()));
        return getLeft().evaluate() - getRight().evaluate();
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
