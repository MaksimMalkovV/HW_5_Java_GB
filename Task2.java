package HW_5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать
 * программу, которая найдет и выведет повторяющиеся имена с количеством
 * повторений. Отсортировать по убыванию популярности.
 */

public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String[] employeeNames = { "Иван",
                "Петр",
                "Ирина",
                "Юра",
                "Иван",
                "Ирина",
                "Иван",
                "Ирина",
                "Светлана",
                "Петр",
                "Светлана",
                "Иван" };
        for (int i = 0; i < employeeNames.length; i++) {
            if (nameMap.containsKey(employeeNames[i])) {
                nameMap.replace(employeeNames[i], nameMap.get(employeeNames[i]) + 1);
            } else {
                nameMap.put(employeeNames[i], 1);
            }
        }
        System.out.println(nameMap);

        // Map<String, Integer> sortMap = new TreeMap<String, Integer>();
        // sortMap.putAll(nameMap);
        // System.out.println(sortMap);
        Map<String, Integer> sortedMap = nameMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));

        sortedMap.entrySet().forEach(System.out::println);

    }

}
