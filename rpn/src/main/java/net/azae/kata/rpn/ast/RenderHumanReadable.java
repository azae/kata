package net.azae.kata.rpn.ast;

import com.google.common.collect.Sets;

import java.util.*;

public class RenderHumanReadable implements NodeVisitor {
    private static final Collection<String> POSTFIX_OPERATORS = Sets.newHashSet("²");
    private static final Map<String, Integer> OPERATOR_PRIORITY = new PriorityDefinition()
            .addOperator("+", "-")
            .raisePriority()
            .addOperator("*", "/")
            .get();

    private final StringBuilder builder = new StringBuilder();
    private final Stack<Integer> priorities = new Stack<>();

    public static String render(final Node ast) {
        final RenderHumanReadable renderer = new RenderHumanReadable();
        ast.accept(renderer);
        return renderer.render();
    }

    String render() {
        return builder.toString();
    }

    public void visitBinaryOperator(final BinaryOperatorNode ast) {
        final String symbol = BinaryOperators.render(ast.getOperator());
        builder.append(enterOperatorPriority(symbol));
        ast.getLeft().accept(this);
        builder.append(' ').append(symbol).append(' ');
        ast.getRight().accept(this);
        builder.append(exitOperatorPriority(symbol));
    }

    public void visitLiteral(final LiteralNode ast) {
        builder.append(ast.getValue());
    }

    public void visitUnaryOperator(final UnaryOperatorNode ast) {
        final String symbol = UnaryOperators.render(ast.getOperator());
        if (POSTFIX_OPERATORS.contains(symbol)) {
            if (ast.getChild() instanceof BinaryOperatorNode) {
                processUnaryOperatorChild(ast);
            } else {
                ast.getChild().accept(this);
            }
            builder.append(symbol);
        } else {
            builder.append(symbol);
            processUnaryOperatorChild(ast);
        }
    }

    private void processUnaryOperatorChild(final UnaryOperatorNode ast) {
        builder.append('(');
        enterForceNoParenthesis();
        ast.getChild().accept(this);
        exitForceNoParenthesis();
        builder.append(')');
    }

    public String enterOperatorPriority(final String operation) {
        final int priority = getOperatorPriority(operation);
        if (!priorities.isEmpty() && priority <= priorities.peek()) {
            priorities.push(priority);
            return "(";
        }
        priorities.push(priority);
        return "";
    }

    public String exitOperatorPriority(final String operation) {
        priorities.pop();
        if (!priorities.isEmpty() && getOperatorPriority(operation) <= priorities.peek()) {
            return ")";
        }
        return "";
    }

    public void enterForceNoParenthesis() {
        priorities.push(0);
    }

    public void exitForceNoParenthesis() {
        priorities.pop();
    }

    private static int getOperatorPriority(final String operation) {
        if (OPERATOR_PRIORITY.containsKey(operation)) {
            return OPERATOR_PRIORITY.get(operation);
        }
        return 0;
    }

    private static final class PriorityDefinition {
        private int currentPriority = 1;

        private final Map<String, Integer> operatorPriority = new LinkedHashMap<>();

        PriorityDefinition raisePriority() {
            currentPriority += 1;
            return this;
        }

        PriorityDefinition addOperator(final String... operators) {
            for (final String operator : operators) {
                operatorPriority.put(operator, currentPriority);
            }
            return this;
        }

        Map<String, Integer> get() {
            return Collections.unmodifiableMap(operatorPriority);
        }
    }
}
