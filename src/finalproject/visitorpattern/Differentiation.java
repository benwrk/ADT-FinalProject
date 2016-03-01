package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * Symbolic Differentiation utilizing the Visitor Design Pattern.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class Differentiation implements Visitor<AbstractExpression> {
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
        return new AdditionExpression(expression.getLeft().accept(this), expression.getRight().accept(this));
    }

    @Override
    public AbstractExpression visit(SubtractionExpression expression) {
        return new SubtractionExpression(expression.getLeft().accept(this), expression.getRight().accept(this));
    }

    @Override
    public AbstractExpression visit(MultiplicationExpression expression) {
        return new AdditionExpression(new MultiplicationExpression(expression.getLeft().accept(this), expression.getRight()), new MultiplicationExpression(expression.getLeft(), expression.getRight().accept(this)));
    }

    @Override
    public AbstractExpression visit(DivisionExpression expression) {
        return new DivisionExpression(new SubtractionExpression(new MultiplicationExpression(expression.getLeft().accept(this), expression.getRight()), new MultiplicationExpression(expression.getLeft(), expression.getRight().accept(this))), new MultiplicationExpression(expression.getRight(), expression.getRight()));
    }

    @Override
    public AbstractExpression visit(NumberExpression expression) {
        return new NumberExpression("0");
    }

    @Override
    public AbstractExpression visit(VariableExpression expression) {
        return new NumberExpression("1");
    }
}
