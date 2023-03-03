package HW_5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    /**
     * Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
     * что один человек может иметь несколько телефонов.
     */

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> nameToPhone = new HashMap<>();// есть возможность не перезаписывать его в
                                                                      // память?
        addNumberPhone("Ivan Ivanov", 456879, nameToPhone);
        addNumberPhone("Nina Nora", 565586, nameToPhone);
        addNumberPhone("Ira Rinova", 56572, nameToPhone);
        addNumberPhone("Heorgiy Torov", 65586, nameToPhone);
        addNumberPhone("Alex Malkov", 789544, nameToPhone);
        printPhoneBook(nameToPhone);// печать изначального справочника
        // addNewNumberPhone(nameToPhone);// добавление контакта
        // printPhoneBook(nameToPhone);// вывод полученного контакта
        searchByKey(nameToPhone);// метод поиска
    }

    public static String dataInputString() {// метод для ввода данных типа String
        Scanner scan1 = new Scanner(System.in);
        String data = scan1.nextLine();
        scan1.close();
        return data;
    }

    public static int dataInputInt() {// метод для ввода данных типа int
        Scanner scan2 = new Scanner(System.in);// Можете подсказать как организовать его правильно
        int data;
        if (scan2.hasNextLine()) {
            data = scan2.nextInt();
        } else
            data = 0;// он всегда выдает это значение. Я устал с ним биться.
        scan2.close();
        return data;
    }

    public static void addNumberPhone(String key, int value, Map<String, ArrayList<Integer>> map) {// метод добавления в
                                                                                                   // существующий
                                                                                                   // список номеров
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static void addNewNumberPhone(Map<String, ArrayList<Integer>> map) {// метод добавления контакта
        System.out.println("Введите имя контакта!");
        String key = dataInputString();
        System.out.println("Введите номер контакта!");
        int value = dataInputInt();
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static void printPhoneBook(Map<String, ArrayList<Integer>> list) {// метод вывода телефонного справочника
        for (Map.Entry<String, ArrayList<Integer>> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void searchByKey(Map<String, ArrayList<Integer>> list) {
        System.out.println("Введите имя контакта!");
        String key = dataInputString();

        if (list.containsKey(key)) {
            System.out.printf("Номер телефона: " + list.get(key));
        } else {
            System.out.println("Контакт не найден");
        }
    }

}
