package org.example;

/**
 * Исследовать работу ArrayList, LinkedList, TreeSet, HashSet. На практике измерить время выполнения операций добавления,
 * поиска и удаления элемента. Сравнить полученные результаты и объяснить, в каком случае какая коллекция работает быстрее.
 */
public class Main {
    public static void main(String[] args) {

        ListTests listTests = new ListTests();
        SetTests setTests = new SetTests();

        //listTests.runTests(); //тесты для ArrayList и LinkedList
        setTests.runTests(); //тесты для TreeSet и HashSet
    }
}