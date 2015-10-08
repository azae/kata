package net.azae.kata.rpn.ast;

public class RenderRpn implements NodeVisitor {
    private final StringBuilder builder = new StringBuilder();

    public static String render(final Node ast) {
        final RenderRpn renderer = new RenderRpn();
        ast.accept(renderer);
        return renderer.render();
    }

    String render() {
        return builder.toString();
    }

    public void visitLiteral(final LiteralNode ast) {
        builder.append(ast.getValue());
    }

    public void visitUnaryOperator(final UnaryOperatorNode ast) {
        ast.getChild().accept(this);
        builder.append(' ').append(UnaryOperators.render(ast.getOperator()));
    }

    public void visitBinaryOperator(final BinaryOperatorNode ast) {
        ast.getLeft().accept(this);
        builder.append(' ');
        ast.getRight().accept(this);
        builder.append(' ').append(BinaryOperators.render(ast.getOperator()));
    }
}
