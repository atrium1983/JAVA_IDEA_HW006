//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
//их необходимо считать, как одного человека с разными телефонами.
//Вывод должен быть отсортирован по убыванию числа телефонов.

package org.example;

import java.util.*;

public class Main {
    private static HashMap<String, ArrayList<Integer>> contactBook = new HashMap<>();
    public static void main(String[] args) {
        addContact("Antonov", 378719);
        addContact("Fedorova", 423515);
        addContact("Fedorova", 350027);
        addContact("Borisov", 323201);
        addContact("Antonov", 458977);
        addContact("Antonov", 378740);
        addContact("Borisova", 415555);
        addContact("Borisov", 331122);
        addContact("Egorova", 445511);
        printContacts();
    }

    public static void addContact(String name, int number){
        if (contactBook.containsKey(name)) {
            contactBook.get(name).add(number);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            contactBook.put(name, list);
        }
    }
    public static void printContacts() {
        ArrayList<Map.Entry<String,ArrayList>> list = new ArrayList(contactBook.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList> item : list){
            System.out.printf("%s: %s \n", item.getKey(), item.getValue().toString().replace("[", "")
                    .replace("]", ""));
        }
    }
}