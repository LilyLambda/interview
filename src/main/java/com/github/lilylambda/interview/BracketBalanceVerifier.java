package com.github.lilylambda.interview;

import java.util.ArrayDeque;

/** Verifies whether strings containing brackets are balanced. */
public class BracketBalanceVerifier {

    private String str;

    private enum Bracket {
        ROUND, SQUARE, CURLY
    }

    public BracketBalanceVerifier(String str) {
        this.str = str;
    }

    /* Return true if parens, square brackets, and curly braces are balanced. */
    public boolean isBalanced() {

        ArrayDeque<Bracket> stack = new ArrayDeque<Bracket>(str.length());

        for(Character c: str.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                if(c == '(') {
                    stack.push(Bracket.ROUND);
                    continue;
                }
                else if(c == '[') {
                    stack.push(Bracket.SQUARE);
                    continue;
                }
                else if(c == '{') {
                    stack.push(Bracket.CURLY);
                    continue;
                }
            }
            else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;
                else if(c == ')') {
                    if(stack.pop() != Bracket.ROUND) return false;
                    continue;
                }
                else if(c == ']') {
                    if(stack.pop() != Bracket.SQUARE) return false;
                    continue;
                }
                if(c == '}') {
                    if(stack.pop() != Bracket.CURLY) return false;
                    continue;
                }
            }
        }
        return stack.isEmpty();
    }
}
