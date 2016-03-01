package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * Symbolic differentiation simplifier utilizing the Visitor Design Pattern.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class DifferentiationSimplifier implements Visitor<AbstractExpression> {
    public AbstractExpression visit(AbstractExpression expression) {
        if (expression instanceof AdditionExpression) {
            return visit((AdditionExpression) expression);
        } else if (expression instanceof SubtractionExpression) {
            return visit((SubtractionExpression) expression);
        } else if (expression instanceof MultiplicationExpression) {
            return visit((MultiplicationExpression) expression);
        } else if (expression instanceof DivisionExpression) {
            return visit((DivisionExpression) expression);
        } else if (expression instanceof NumberExpression) {
            return visit((NumberExpression) expression);
        } else if (expression instanceof VariableExpression) {
            return visit((VariableExpression) expression);
        }
        return new NumberExpression("0");
    }

    @Override
    public AbstractExpression visit(AdditionExpression expression) {
        AbstractExpression left = expression.getLeft().accept(this);
        AbstractExpression right = expression.getRight().accept(this);
//        if (left.getDatum().equals("0") && right.getDatum().equals("0")) {
//            return new NumberExpression("0");
//        } else if (left.getDatum().equals("0")) {
//            return right;
//        } else if (right.getDatum().equals("0")) {
//            return left;
//        } else if (left.getDatum().equals(right.getDatum())) {
//            return new MultiplicationExpression(new NumberExpression("2"), right);
//        } else {
//            return new AdditionExpression(left, right);
//        }
        if (left.evaluate() == 0 && right.evaluate() == 0) {
            return new NumberExpression("0");
        } else if (left.evaluate() == 0) {
            return right.accept(this);
        } else if (right.evaluate() == 0) {
            return left.accept(this);
        } else if (left.evaluate() == right.evaluate()) {
            return new MultiplicationExpression(new NumberExpression("2"), right.accept(this));
        } else {
            return new AdditionExpression(left.accept(this), right.accept(this));
        }
    }

    @Override
    public AbstractExpression visit(SubtractionExpression expression) {
        AbstractExpression left = expression.getLeft().accept(this);
        AbstractExpression right = expression.getRight().accept(this);
//        if (left.getDatum().equals("0") && right.getDatum().equals("0")) {
//            return new NumberExpression("0");
//        } else if (right.getDatum().equals("0")) {
//            return left;
//        } else if (left.getDatum().equals(right.getDatum())) {
//            return new NumberExpression("0");
//        } else {
//            return new SubtractionExpression(left, right);
//        }
        if (right.evaluate() == 0) {
            return left.accept(this);
        } else if (right.evaluate() == left.evaluate()) {
            return new NumberExpression("0");
        } else {
            return new SubtractionExpression(left.accept(this), right.accept(this));
        }
    }

    @Override
    public AbstractExpression visit(MultiplicationExpression expression) {
        AbstractExpression left = expression.getLeft().accept(this);
        AbstractExpression right = expression.getRight().accept(this);
        if (left.evaluate() == 0 || right.evaluate() == 0) {
            return new NumberExpression("0");
        } else if (left.evaluate() == 1) {
            return right.accept(this);
        } else if (right.evaluate() == 1) {
            return left.accept(this);
        } else {
            return new MultiplicationExpression(left.accept(this), right.accept(this));
        }
    }

    @Override
    public AbstractExpression visit(DivisionExpression expression) {
//        return new DivisionExpression(new SubtractionExpression(new MultiplicationExpression(expression.getLeft().accept(this), expression.getRight()), new MultiplicationExpression(expression.getLeft(), expression.getRight().accept(this))), new MultiplicationExpression(expression.getRight(), expression.getRight()));
        AbstractExpression left = expression.getLeft().accept(this);
        AbstractExpression right = expression.getRight().accept(this);
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Division by zero!");
        } else if (left.evaluate() == 0) {
            return new NumberExpression("0");
        } else if (right.evaluate() == 1) {
            return left.accept(this);
        } else if (left.evaluate() == right.evaluate()) {
            return new NumberExpression("1");
        } else {
            return new DivisionExpression(left.accept(this), right.accept(this));
        }
    }

    @Override
    public AbstractExpression visit(NumberExpression expression) {
        return expression;
    }

    @Override
    public AbstractExpression visit(VariableExpression expression) {
        return expression;
    }
}
