package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTests {

    void runTests() {

        //test1(); // тест на добавление 1млн элементов в TreeSet и HashSet
        //test2(); // тест на скорость поиска элементов в TreeSet и HashSet
        test3(); // тест на удаление 1млн элементов в TreeSet и HashSet
    }

    private void test3() {

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        long t1 = 0; // количество миллисекунд, за которое в HashSet обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в HashSet обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в HashSet обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в TreeSet обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в TreeSet обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в TreeSet обработали все элементы

        for (int i = 0; i < 1000000; i++) {  //заполняем для дальнейших экспериментов

            hashSet.add(i);
            treeSet.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 500000 элементов в HashSet удалили за " + t1 + "мс");
            }

            hashSet.remove(i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 500000 элементов в HashSet удалили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на удаление в HashSet 1млн элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 500000 элементов в TreeSet удалили за " + t4 + "мс");
            }

            hashSet.remove(i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 500000 элементов в TreeSet удалили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на удаление в TreeSet 1млн элементов");
        System.out.println("\nИтого, в данном тесте TreeSet выигрывает в номинациях:" +
                "\nПервые 500000 элементов удалены быстрее на " + (t1 - t4) + "мс" +
                "\nОставшиеся 500000 элементов удалены быстрее на " + (t2 - t5) + "мс" +
                "\nИ, в целом, на удаление 1млн элементов потребовалось на " + (t3 - t6) + "мс меньше");
    }

    private void test2() {

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        long t1 = 0; // количество миллисекунд, за которое в HashSet обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в HashSet обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в HashSet обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в TreeSet обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в TreeSet обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в TreeSet обработали все элементы

        for (int i = 0; i < 1000000; i++) { //заполняем для дальнейших экспериментов

            hashSet.add(i);
            treeSet.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 400000; i < 600000; i++) {

            if (i == 500000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 100000 элементов в HashSet нашли за " + t1 + "мс");
            }

            hashSet.add(i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 100000 элементов в HashSet нашли за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на поиск в HashSet 200000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 400000; i < 600000; i++) {

            if (i == 500000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 100000 элементов в TreeSet нашли за " + t4 + "мс");
            }

            treeSet.add(i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 100000 элементов в TreeSet нашли за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на поиск в TreeSet 200000 элементов");
       /* System.out.println("\nИтого, в данном тесте TreeSet выигрывает в номинациях:" +
                "\nПервые 100000 элементов нашли быстрее на " + (t1 - t4) + "мс" +
                "\nОставшиеся 100000 элементов нашли быстрее на " + (t2 - t5) + "мс" +
                "\nИ, в целом, на поиск 200000 элементов потребовалось на " + (t3 - t6) + "мс меньше");*/
    }

    private void test1() {

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        long t1 = 0; // количество миллисекунд, за которое в HashSet обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в HashSet обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в HashSet обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в TreeSet обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в TreeSet обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в TreeSet обработали все элементы

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 500000 элементов в HashSet добавили за " + t1 + "мс");
            }

            hashSet.add(i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 500000 элементов в HashSet добавили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на добавление в HashSet 1млн элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 500000 элементов в TreeSet добавили за " + t4 + "мс");
            }

            treeSet.add(i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 500000 элементов в TreeSet добавили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на добавление в TreeSet 1млн элементов");
        System.out.println("\nИтого, в данном тесте HashSet выигрывает в номинациях:" +
                "\nПервые 500000 элементов добавлены быстрее на " + (t4 - t1) + "мс" +
                "\nОставшиеся 500000 элементов добавлены быстрее на " + (t5 - t2) + "мс" +
                "\nИ, в целом, на добавление 1млн элементов потребовалось на " + (t6 - t3) + "мс меньше");
    }
}
