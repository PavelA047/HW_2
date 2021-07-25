package hw_23072021;

import java.util.*;

public class PhoneDirectory {
    private static final Map<String, List<String>> phoneDirectory = new TreeMap<>();

    static void add(String surname, String... phoneNumbers) {
        List<String> phones = new ArrayList<>(Arrays.asList(phoneNumbers));
        phoneDirectory.put(surname, phones);
    }

    static List<String> get(String surname) {
        return phoneDirectory.getOrDefault(surname, new ArrayList<>(Arrays.asList("no numbers")));
    }
}
