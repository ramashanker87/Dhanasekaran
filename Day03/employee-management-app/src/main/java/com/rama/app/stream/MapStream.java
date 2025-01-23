package com.rama.app.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapStream {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("emp1", 100000);
        map1.put("emp2", 20000);
        map1.put("emp3", 55000);
        map1.put("emo4", 75500);
        map1.put("emp5", 32000);
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Map<String, Integer> salaryLess50k = map1.
                entrySet().stream()
                .filter(entry -> entry.getValue() < 50000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Employee with Salary 50000: " + salaryLess50k);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("emp1", 35);
        map2.put("emp2", 24);
        map2.put("emp3", 55);
        map2.put("emo4", 19);
        map2.put("emp5", 29);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Map<String, Integer> ageGreaterThan25 = map2.
                entrySet().stream()
                .filter(entry -> entry.getValue() > 25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Employee with Age Greater Than 25: " + ageGreaterThan25);
    }
}
