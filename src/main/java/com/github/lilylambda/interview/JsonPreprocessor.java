package com.github.lilylambda.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

/** Removes C-style comments from a JSON document. */
public class JsonPreprocessor {

    private String rawJson;

    public JsonPreprocessor(String rawJson) {
        this.rawJson = rawJson;
    }

    /**
     * Return program text with C-style comments removed.
     *
     * Note: CR/LF handling by Scanner class. Output will be normalized to Unix LF-only.
     */
    public String removeComments() {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(rawJson);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            builder.append(stripCStyleComment(line) + "\n");
        }
        scanner.close();
        return builder.toString();
    }

    private String stripCStyleComment(String line) {
        StringBuilder init = new StringBuilder(line.length());
        Character last = null;
        boolean inQuote = false;
        boolean inEscape = false;
        for(Character c: line.toCharArray()) {
            if(inQuote == false) {
                if(last != null && last == '/' && c == '/') {
                    return init.toString();
                }
            }
            if(c == '"') {
                if(last == '\\') {
                    if(init.length() > 0 && init.charAt(init.length() - 1) == '\\') { //literal backslash
                        inQuote = !inQuote;
                    }
                    //otherwise, this is a literal quote, not affecting quote mode
                }
                else {
                    inQuote = !inQuote;
                }
            }
            if(last != null) {
                init.append(last);
            }
            last = c;
        }
        init.append(last);
        return init.toString();
    }
}
