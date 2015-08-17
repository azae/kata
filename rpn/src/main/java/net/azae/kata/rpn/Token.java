package net.azae.kata.rpn;

import java.util.Stack;

interface Token {
    int process(final String atom, final Stack<Integer> stack);
}
