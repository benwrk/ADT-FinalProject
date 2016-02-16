package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * Symbolic Differentiation utilizing the Visitor Design Pattern.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class Differentiation implements Visitor<Expression> {
    public Expression visit(Expression expression) {
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
    public Expression visit(AdditionExpression expression) {
        return new AdditionExpression(expression.getLeft().accept(this), expression.getRight().accept(this));
    }

    @Override
    public Expression visit(SubtractionExpression expression) {
        return new SubtractionExpression(expression.getLeft().accept(this), expression.getRight().accept(this));
    }

    @Override
    public Expression visit(MultiplicationExpression expression) {
        return new AdditionExpression(new MultiplicationExpression(expression.getLeft().accept(this), expression.getRight()), new MultiplicationExpression(expression.getLeft(), expression.getRight().accept(this)));
    }

    @Override
    public Expression visit(DivisionExpression expression) {
        return new DivisionExpression(new SubtractionExpression(new MultiplicationExpression(expression.getLeft().accept(this), expression.getRight()), new MultiplicationExpression(expression.getLeft(), expression.getRight().accept(this))), new MultiplicationExpression(expression.getRight(), expression.getRight()));
    }

    @Override
    public Expression visit(NumberExpression expression) {
        return new NumberExpression("0");
    }

    @Override
    public Expression visit(VariableExpression expression) {
        return new NumberExpression("1");
    }
}
