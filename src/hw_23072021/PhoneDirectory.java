package hw_23072021;

import java.util.*;

public class PhoneDirectory {
    private static final Map<String, Set<String>> phoneDirectory = new TreeMap<>();

    static void add(String surname, String... phoneNumbers) {
        Set<String> phones = new TreeSet<>(Arrays.asList(phoneNumbers));
        try {
            phoneDirectory.get(surname).addAll(phones);
        } catch (NullPointerException e) {
            phoneDirectory.put(surname, phones);
        }
    }

    static Set<String> get(String surname) {
        return phoneDirectory.getOrDefault(surname, new TreeSet<>(Arrays.asList("no numbers")));
    }
}
