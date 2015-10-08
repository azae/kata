package net.azae.kata.rpn.ast;

import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static net.azae.kata.rpn.ast.NodeFactory.*;

public class RpnParser implements Parser {
    public Node parse(final String expression) {
        final Stack<Node> stack = new Stack<>();
        for (final String atom : expression.split("\\s+")) {
            StackActions.process(atom, stack);
        }
        return stack.pop();
    }

    private enum StackActions {
        ADD("+"::equals, stack -> stack.push(binary(stack, NodeFactory::add))),
        SUB("-"::equals, stack -> stack.push(binary(stack, NodeFactory::sub))),
        MUL("*"::equals, stack -> stack.push(binary(stack, NodeFactory::mul))),
        DIV("/"::equals, stack -> stack.push(binary(stack, NodeFactory::div))),
        NEG("NEG"::equals, stack -> stack.push(neg(stack.pop()))),
        SQRT("SQRT"::equals, stack -> stack.push(sqrt(stack.pop())));

        final Predicate<String> pattern;
        final Consumer<Stack<Node>> operation;

        StackActions(final Predicate<String> pattern, final Consumer<Stack<Node>> operation) {
            this.pattern = pattern;
            this.operation = operation;
        }

        static void process(final String atom, final Stack<Node> stack) {
            for (final StackActions action : values()) {
                if (action.pattern.test(atom)) {
                    action.operation.accept(stack);
                    return;
                }
            }
            stack.push(literal(atom));
        }

        private static Node binary(final Stack<Node> stack, final BinaryOperator<Node> function) {
            final Node right = stack.pop();
            final Node left = stack.pop();
            return function.apply(left, right);
        }
    }
}
