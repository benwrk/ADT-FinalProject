package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * An evaluator that utilizes the Visitor Design Pattern.
 *
 * @author Benjapol Worakan
 * @version 15.12.26
 */
public class Evaluator implements Visitor<Integer> {
    public Integer visit(AbstractExpression expression) {
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
        return 0;
    }

    @Override
    public Integer visit(AdditionExpression expression) {
        return expression.getLeft().accept(this) + expression.getRight().accept(this);
    }

    @Override
    public Integer visit(SubtractionExpression expression) {
        return expression.getLeft().accept(this) - expression.getRight().accept(this);
    }

    @Override
    public Integer visit(MultiplicationExpression expression) {
        return expression.getLeft().accept(this) * expression.getRight().accept(this);
    }

    @Override
    public Integer visit(DivisionExpression expression) {
        return expression.getLeft().accept(this) / expression.getRight().accept(this);
    }

    @Override
    public Integer visit(NumberExpression expression) {
        return expression.evaluate();
    }

    @Override
    public Integer visit(VariableExpression expression) {
        return expression.evaluate();
    }
}
