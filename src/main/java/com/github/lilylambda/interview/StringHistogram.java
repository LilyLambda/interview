package com.github.lilylambda.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/** A histogram of character frequencies from an arbitrary String. */
public class StringHistogram {

    private HashMap<Character, Integer> map;

    /** Create histogram with the provided string. */
    public StringHistogram(String s) {
        map = new HashMap<>(s.length());
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
    }

    /** Generate a string that displays the histogram characters followed by a string of hashes equal to the equal
     * to the character's frequency. They characters are sorted first by their frequencies, and second by
     * the natural order of the characters. */
    public String pretty() {
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Vector<Map.Entry<Character, Integer>> entries = new Vector(entrySet);
        entries.sort((e1, e2) -> {
            if(e1.getValue() != e2.getValue()) {
                return e2.getValue().compareTo(e1.getValue());
            }
            else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: entries) {
            StringBuilder hashes = new StringBuilder();
            for(int i = 0; i < entry.getValue(); i++) {
                hashes.append("#");
            }
            builder.append(String.format("%s: %s%n", entry.getKey(), hashes.toString()));
        }
        return builder.toString();
    }
}
