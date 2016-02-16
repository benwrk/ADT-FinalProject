package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * An interface for Visitor Design Pattern.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public interface Visitor<T> {
    T visit(AdditionExpression expression);

    T visit(SubtractionExpression expression);

    T visit(MultiplicationExpression expression);

    T visit(DivisionExpression expression);

    T visit(NumberExpression expression);

    T visit(VariableExpression expression);
}
