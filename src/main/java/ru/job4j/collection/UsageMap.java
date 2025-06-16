package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("petr@mail.ru", "Петров Петр Петрович");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println();
        map.put("petr@mail.ru", "Иванов Иван Иванович");
        map.put("smirnov@mail.ru", "Смирнов Игорь Игоревич");
        map.put("smirnova@mail.ru", "Смирнова Елена Игоревна");
        map.put("miron@mail.ru", "Миронов Михаил Михайлович");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
