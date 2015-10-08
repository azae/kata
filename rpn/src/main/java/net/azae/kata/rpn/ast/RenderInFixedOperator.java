package net.azae.kata.rpn.ast;

public class RenderInFixedOperator implements NodeVisitor {
    private final StringBuilder builder = new StringBuilder();

    public static String render(final Node ast) {
        final RenderInFixedOperator renderer = new RenderInFixedOperator();
        ast.accept(renderer);
        return renderer.render();
    }

    String render() {
        return builder.toString();
    }

    public void visitBinaryOperator(final BinaryOperatorNode ast) {
        builder.append('(');
        ast.getLeft().accept(this);
        builder.append(' ').append(BinaryOperators.render(ast.getOperator())).append(' ');
        ast.getRight().accept(this);
        builder.append(')');
    }

    public void visitLiteral(final LiteralNode ast) {
        builder.append(ast.getValue());
    }

    public void visitUnaryOperator(final UnaryOperatorNode ast) {
        builder.append(UnaryOperators.render(ast.getOperator())).append('(');
        ast.getChild().accept(this);
        builder.append(')');
    }
}
