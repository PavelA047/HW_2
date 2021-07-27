package hw_23072021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Russia", "USA", "USSR", "Great Britain", "Germany",
                "USSR", "France", "Spain", "Denmark", "Sweden", "Germany", "Norway", "Finland", "Sweden",
                "USA", "Switzerland", "Norway", "Austria", "USA", "Monaco"));
        Map<String, Integer> mapList = new TreeMap<>();
        for (String country : list) {
            int value = mapList.getOrDefault(country, 0);
            mapList.put(country, value + 1);
        }
        System.out.println(mapList);
        System.out.println();

        PhoneDirectory.add("Ivan", "8(905)940-14-82");
        PhoneDirectory.add("Igor", "8(903)951-22-43");
        PhoneDirectory.add("Fedor", "8(923)940-14-23");
        PhoneDirectory.add("Petr", "8(915)940-14-15", "8(999)654-87-98", "8(950)996-78-87");
        PhoneDirectory.add("Igor", "8(999)940-14-99");
        PhoneDirectory.add("Pavel", "8(916)940-14-16");
        System.out.println(PhoneDirectory.get("Pavel"));
        System.out.println(PhoneDirectory.get("Nikita"));
        System.out.println(PhoneDirectory.get("Petr"));
        System.out.println(PhoneDirectory.get("Igor"));
    }
}
