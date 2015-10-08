package net.azae.kata.rpn.ast;

import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static net.azae.kata.rpn.ast.NodeFactory.sqrt;

public class RpnParser implements Parser {
    public Node parse(final String expression) {
        final Stack<Node> stack = new Stack<>();
        for (final String atom : expression.split("\\s+")) {
            StackActions.process(atom, stack);
        }
        return stack.pop();
    }

    private enum StackActions {
        ADD("+"::equals, (atom, stack) -> stack.push(binary(stack, NodeFactory::add))),
        SUB("-"::equals, (atom, stack) -> stack.push(binary(stack, NodeFactory::sub))),
        MUL("*"::equals, (atom, stack) -> stack.push(binary(stack, NodeFactory::mul))),
        DIV("/"::equals, (atom, stack) -> stack.push(binary(stack, NodeFactory::div))),
        SQRT("SQRT"::equals, (atom, stack) -> stack.push(sqrt(stack.pop())));

        final Predicate<String> pattern;
        final BiConsumer<String, Stack<Node>> operation;

        StackActions(final Predicate<String> pattern, final BiConsumer<String, Stack<Node>> operation) {
            this.pattern = pattern;
            this.operation = operation;
        }

        static void process(final String atom, final Stack<Node> stack) {
            for (final StackActions action : values()) {
                if (action.pattern.test(atom)) {
                    action.operation.accept(atom, stack);
                    return;
                }
            }
            stack.push(NodeFactory.literal(atom));
        }

        private static Node binary(final Stack<Node> stack, final BinaryOperator<Node> function) {
            final Node right = stack.pop();
            final Node left = stack.pop();
            return function.apply(left, right);
        }
    }
}
