package net.azae.kata.rpn.ast;

public interface Node {
    void accept(final NodeVisitor visitor);
}
