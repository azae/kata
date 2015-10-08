package net.azae.kata.rpn.ast;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class EvaluatorDouble implements NodeVisitor {
    private static final Map<BinaryOperators, Consumer<Stack<Double>>> BINARY_OPERATORS = new HashMap<BinaryOperators, Consumer<Stack<Double>>>() {
        {
            put(BinaryOperators.ADD, s -> binary(s, (x, y) -> x + y));
            put(BinaryOperators.DIV, s -> binary(s, (x, y) -> x / y));
            put(BinaryOperators.MUL, s -> binary(s, (x, y) -> x * y));
            put(BinaryOperators.SUB, s -> binary(s, (x, y) -> x - y));
        }
    };

    private static final Map<UnaryOperators, Consumer<Stack<Double>>> UNARY_OPERATORS = new HashMap<UnaryOperators, Consumer<Stack<Double>>>() {
        {
            put(UnaryOperators.NEG, s -> s.push(-s.pop()));
            put(UnaryOperators.SQRT, s -> s.push(Math.sqrt(s.pop())));
        }
    };

    private static void binary(final Stack<Double> stack, final BinaryOperator<Double> function) {
        final double y = stack.pop();
        final double x = stack.pop();
        stack.push(function.apply(x, y));
    }

    private final Stack<Double> stack = new Stack<>();

    public static double evaluate(final Node ast) {
        final EvaluatorDouble renderer = new EvaluatorDouble();
        ast.accept(renderer);
        return renderer.value();
    }

    private double value() {
        return stack.pop();
    }

    public void visitBinaryOperator(final BinaryOperatorNode ast) {
        ast.getLeft().accept(this);
        ast.getRight().accept(this);
        BINARY_OPERATORS.get(ast.getOperator()).accept(stack);
    }

    public void visitLiteral(final LiteralNode ast) {
        stack.push(Double.valueOf(ast.getValue()));
    }

    public void visitUnaryOperator(final UnaryOperatorNode ast) {
        ast.getChild().accept(this);
        UNARY_OPERATORS.get(ast.getOperator()).accept(stack);
    }
}
