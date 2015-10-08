package net.azae.kata.rpn.ast;

public interface NodeVisitor {
    void visitBinaryOperator(final BinaryOperatorNode ast);

    void visitLiteral(final LiteralNode ast);

    void visitUnaryOperator(final UnaryOperatorNode ast);
}
