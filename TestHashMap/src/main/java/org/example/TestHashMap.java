package org.example;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Поменять местами ключи и значения в HashMap.
 */

public class TestHashMap {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < 10; i++) {

            map.put(i, (11 + i));
        }

        System.out.println(map);

        revers1(map);
        revers2(map);
        revers3(map); // без создания новой мапы
    }

    private static void revers3(Map<Integer, Integer> map) {

        List<Integer> newV = new ArrayList<>(map.keySet());
        List<Integer> newK = new ArrayList<>(map.values());

        for (Integer integer : newV) {

            map.remove(integer);
        }

        for (int i = 0; i < newV.size(); i++) {

            map.put(newK.get(i), newV.get(i));
        }

        System.out.println(map);
    }

    private static void revers2(Map<Integer, Integer> map) {

        Map<Integer, Integer> revers = new HashMap<>();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            revers.put(integerIntegerEntry.getValue(), integerIntegerEntry.getKey());
        }

        System.out.println(revers);
    }

    private static void revers1(Map<Integer, Integer> map) {

        Map<Integer, Integer> revers = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        System.out.println(revers);
    }
}