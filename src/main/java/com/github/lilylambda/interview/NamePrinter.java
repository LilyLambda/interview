package com.github.lilylambda.interview;

import java.util.Map;
import java.util.Vector;

/** Prints names hashes (from first to last name) nicely. */
public class NamePrinter {

    private Map<String, String> names;

    public NamePrinter(Map<String, String> names) {
        this.names = names;
    }

    /**
     * Generate a pretty representation of the map, listing full names primarily sorted
     * by length of last name, with secondary sort alphabetically by first name.
     *
     * Note: all characters count toward the length of a name
     */
    public String pretty() {
        Vector<Map.Entry<String, String>> entries = new Vector(names.entrySet());
        entries.sort((e1, e2) -> {
            int lastNameLength1 = e1.getValue().length();
            int lastNameLength2 = e2.getValue().length();
            if(lastNameLength1 < lastNameLength2) {
                return -1;
            }
            else if(lastNameLength1 > lastNameLength2) {
                return 1;
            }
            else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String, String> entry: entries) {
            builder.append(String.format("%s %s%n", entry.getKey(), entry.getValue()));
        }
        return builder.toString();
    }
}
