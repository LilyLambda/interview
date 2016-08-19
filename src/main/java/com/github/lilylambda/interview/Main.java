package com.github.lilylambda.interview;

import java.util.HashMap;

/** Entrypoint to run examples. */
public class Main {

    public static void main(String[] args) {
        new Main().printQuestions();
    }

    public void printQuestions() {
        System.out.println("Interview Questions.");
        System.out.println();
        printQuestion1();
        System.out.println();
        printQuestion2();
        System.out.println();
        printQuestion3();
        System.out.println();
        printQuestion4();
        System.out.println();
        printQuestion5();
    }

    private static void printQuestion1() {
        System.out.println("Question 1:");
        String pretty = new StringHistogram("Mississippi borders Tennessee.").pretty();
        System.out.println(pretty);
    }

    private void printQuestion2() {
        HashMap<String, String> names = new HashMap<>();
        names.put("Elizabeth", "Davis");
        names.put("Mary", "Li");
        names.put("James", "O'Day");
        names.put("William", "Garcia");
        names.put("Thomas", "Miller");


        System.out.println("Question 2:");
        String pretty = new NamePrinter(names).pretty();
        System.out.println(pretty);
    }

    private void printQuestion3() {
        System.out.println("Question 3:");
        printQuestion3Example("([])");
        printQuestion3Example("[]{}");
        printQuestion3Example("([)]");
        printQuestion3Example("](){");
    }

    private void printQuestion3Example(String ex) {
        System.out.println(String.format("%s balanced? %s", ex, new BracketBalanceVerifier(ex).isBalanced()));
    }

    private void printQuestion4() {
        System.out.println("Question 4:");
        System.out.println("[Answer is in README.md in root.]");
    }

    private void printQuestion5() {
        System.out.println("Question 5:");
        StringBuilder builder = new StringBuilder();
        builder.append("// this is a comment\n");
        builder.append("{ // another comment\n");
        builder.append("    true, \"foo\", // 3rd comment\n");
        builder.append("    \"http://www.ariba.com\", // comment after URL\n");
        builder.append("    \"\\\"//foo\", // escaped quotes are tricky\n");
        builder.append("    \"\\\\\"// so are literal backslashes\n");
        builder.append("}\n");
        System.out.println(new JsonPreprocessor(builder.toString()).removeComments());
    }
}
