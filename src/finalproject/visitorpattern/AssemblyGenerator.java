package finalproject.visitorpattern;

import finalproject.expression.*;

/**
 * MIPS Assembly Generator utilizing the Visitor Design Pattern.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class AssemblyGenerator implements Visitor<String> {
    private static final String MIPS_MOVE_STACK_POINTER_UP = "addiu $sp, $sp, -4\n";
    private static final String MIPS_MOVE_STACK_POINTER_DOWN = "addiu $sp, $sp, 4\n\n";
    private static final String MIPS_LOAD_WORD = "lw $t1, 4($sp)\n";
    private static final String MIPS_STORE_WORD = "sw $a0, 0($sp)\n";
    private static final String MIPS_CALC_PREP = MIPS_STORE_WORD + MIPS_MOVE_STACK_POINTER_UP;
    private static final String MIPS_HEADER = ".text\n.globl main\nmain:\n\n";
    private static final String MIPS_PRINT_INT = "li $v0, 1\nsyscall\n\n";
    private static final String MIPS_EXIT = "li $v0, 10\nsyscall\n";

    public String visit(AbstractExpression expression) {
        String mipsCode = MIPS_HEADER;
        if (expression instanceof AdditionExpression) {
            mipsCode += visit((AdditionExpression) expression);
        } else if (expression instanceof SubtractionExpression) {
            mipsCode += visit((SubtractionExpression) expression);
        } else if (expression instanceof MultiplicationExpression) {
            mipsCode += visit((MultiplicationExpression) expression);
        } else if (expression instanceof DivisionExpression) {
            mipsCode += visit((DivisionExpression) expression);
        } else if (expression instanceof NumberExpression) {
            mipsCode += visit((NumberExpression) expression);
        } else if (expression instanceof VariableExpression) {
            mipsCode += visit((VariableExpression) expression);
        }
        return mipsCode + MIPS_PRINT_INT + MIPS_EXIT;
    }

    @Override
    public String visit(AdditionExpression expression) {
        return expression.getLeft().accept(this) + "\n" +
                MIPS_CALC_PREP +
                expression.getRight().accept(this) + "\n" +
                MIPS_LOAD_WORD +
                "add $a0, $t1, $a0" + "\n" +
                MIPS_MOVE_STACK_POINTER_DOWN;
    }

    @Override
    public String visit(SubtractionExpression expression) {
        return expression.getLeft().accept(this) + "\n" +
                MIPS_CALC_PREP +
                expression.getRight().accept(this) + "\n" +
                MIPS_LOAD_WORD +
                "sub $a0, $t1, $a0" + "\n" +
                MIPS_MOVE_STACK_POINTER_DOWN;
    }

    @Override
    public String visit(MultiplicationExpression expression) {
        return expression.getLeft().accept(this) + "\n" +
                MIPS_CALC_PREP +
                expression.getRight().accept(this) + "\n" +
                MIPS_LOAD_WORD +
                "mul $a0, $t1, $a0" + "\n" +
                MIPS_MOVE_STACK_POINTER_DOWN;
    }

    @Override
    public String visit(DivisionExpression expression) {
        return expression.getLeft().accept(this) + "\n" +
                MIPS_CALC_PREP +
                expression.getRight().accept(this) + "\n" +
                MIPS_LOAD_WORD +
                "div $a0, $t1, $a0" + "\n" +
                MIPS_MOVE_STACK_POINTER_DOWN;
    }

    @Override
    public String visit(NumberExpression expression) {
        return "li $a0, " + expression.evaluate();
    }

    @Override
    public String visit(VariableExpression expression) {
        return "la $a0, " + expression.getDatum();
    }
}
