package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTests {

    void runTests() {

        test1(); // тест на добавление 1млн элементов в конец ArrayList и LinkedList
        test2(); // тест на добавление элементов в начало ArrayList и LinkedList
        test3(); //тест на добавление 100000 элементов в середину ArrayList и LinkedList
        test4(); //тест на изменение 50000 элементов в середине ArrayList и LinkedList
        test5(); //тест на удаление 50000 элементов в начале ArrayList и LinkedList
        test6(); //тест на удаление 50000 элементов в конце ArrayList и LinkedList
        test7(); //тест на удаление 50000 элементов в середине ArrayList и LinkedList
    }

    private  void test7() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы

        for (int i = 0; i < 100000; i++) {   //заполняем для дальнейших экспериментов
            list1.add(i);
            list2.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 75000; i > 25000; i--) {

            if (i == 50000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 25000 элементов в ArrayList удалили за " + t1 + "мс");
            }

            list1.remove(i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 25000 элементов в ArrayList удалили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на удаление из ArrayList 50000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 75000; i > 25000; i--) {

            if (i == 50000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 25000 элементов в LinkedList удалили за " + t4 + "мс");
            }

            list2.remove(i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 25000 элементов в LinkedList удалили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на удаление из LinkedList 50000 элементов");
        System.out.println("\nИтого, в данном тесте ArrayList выигрывает в номинациях:" +
                "\nПервые 25000 элементов удалили быстрее на " + (t4 - t1) + "мс" +
                "\nОставшиеся 25000 элементов удалили быстрее на " + (t5 - t2) + "мс" +
                "\nИ, в целом, на удаление 50000 элементов потребовалось на " + (t6 - t3) + "мс меньше");
    }

    private  void test6() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы

        for (int i = 0; i < 100000; i++) {   //заполняем для дальнейших экспериментов

            list1.add(i);
            list2.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 100000; i > 50000; i--) {

            if (i == 75000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 25000 элементов в ArrayList удалили за " + t1 + "мс");
            }

            list1.remove(i - 1);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 25000 элементов в ArrayList удалили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на удаление из ArrayList 50000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 100000; i > 50000; i--) {

            if (i == 75000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 25000 элементов в LinkedList удалили за " + t4 + "мс");
            }

            list2.remove(i - 1);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 25000 элементов в LinkedList удалили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на удаление из LinkedList 50000 элементов");
        System.out.println("\nИтого, в данном тесте LinkedList выигрывает в номинациях:" +
                "\nПервые 25000 элементов удалили быстрее на " + (t1 - t4) + "мс" +
                "\nОставшиеся 25000 элементов удалили быстрее на " + (t2 - t5) + "мс" +
                "\nИ, в целом, на удаление 50000 элементов потребовалось на " + (t3 - t6) + "мс меньше");
    }

    private  void test5() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы

        for (int i = 0; i < 100000; i++) {   //заполняем для дальнейших экспериментов

            list1.add(i);
            list2.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 1; i < 50000; i++) {

            if (i == 25000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 25000 элементов в ArrayList удалили за " + t1 + "мс");
            }

            list1.remove(0);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 25000 элементов в ArrayList удалили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на удаление из ArrayList 50000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;
        for (int i = 1; i < 50000; i++) {

            if (i == 25000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 25000 элементов в LinkedList удалили за " + t4 + "мс");
            }

            list2.remove(0);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 25000 элементов в LinkedList удалили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на удаление из LinkedList 50000 элементов");
        System.out.println("\nИтого, в данном тесте LinkedList выигрывает в номинациях:" +
                "\nПервые 25000 элементов удалили быстрее на " + (t1 - t4) + "мс" +
                "\nОставшиеся 25000 элементов удалили быстрее на " + (t2 - t5) + "мс" +
                "\nИ, в целом, на удаление 50000 элементов потребовалось на " + (t3 - t6) + "мс меньше");
    }

    private  void test4() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы

        for (int i = 0; i < 100000; i++) {   //заполняем для дальнейших экспериментов

            list1.add(i);
            list2.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 75000; i > 25000; i--) {

            if (i == 50000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 25000 элементов в ArrayList изменили за " + t1 + "мс");
            }
            list1.set(i, i / 2);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 25000 элементов в ArrayList изменили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на изменение в ArrayList 50000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 75000; i > 25000; i--) {

            if (i == 50000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 25000 элементов в LinkedList изменили за " + t4 + "мс");
            }

            list2.set(i, i / 2);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 25000 элементов в LinkedList изменили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на изменение в LinkedList 50000 элементов");
        System.out.println("\nИтого, в данном тесте ArrayList выигрывает в номинациях:" +
                "\nПервые 25000 элементов изменены быстрее на " + (t4 - t1) + "мс" +
                "\nОставшиеся 25000 элементов изменены быстрее на " + (t5 - t2) + "мс" +
                "\nИ, в целом, на изменение 50000 элементов потребовалось на " + (t6 - t3) + "мс меньше");
    }

    private  void test3() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы

        for (int i = 0; i < 100000; i++) {   //заполняем для дальнейших экспериментов

            list1.add(i);
            list2.add(i);
        }

        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 0; i < 10000; i++) {

            if (i == 5000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 5000 элементов в ArrayList добавили за " + t1 + "мс");
            }

            list1.add(50000, i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 5000 элементов в ArrayList добавили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на добавление в ArrayList 10000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 0; i < 10000; i++) {

            if (i == 5000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 5000 элементов в LinkedList добавили за " + t4 + "мс");
            }

            list2.add(50000, i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 5000 элементов в LinkedList добавили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на добавление в LinkedList 10000 элементов");
        System.out.println("\nИтого, в данном тесте ArrayList выигрывает в номинациях:" +
                "\nПервые 5000 элементов добавлены быстрее на " + (t4 - t1) + "мс" +
                "\nОставшиеся 5000 элементов добавлены быстрее на " + (t5 - t2) + "мс" +
                "\nИ, в целом, на добавление 10000 элементов потребовалось на " + (t6 - t3) + "мс меньше");
    }

    private  void test2() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы


        long x1 = System.currentTimeMillis();
        long x2 = 0;
        for (int i = 0; i < 100000; i++) {

            if (i == 50000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 50000 элементов в ArrayList добавили за " + t1 + "мс");
            }

            list1.add(0, i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 50000 элементов в ArrayList добавили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на добавление в ArrayList 100000 элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 0; i < 100000; i++) {

            if (i == 50000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 50000 элементов в LinkedList добавили за " + t4 + "мс");
            }

            list2.add(0, i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 50000 элементов в LinkedList добавили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на добавление в LinkedList 100000 элементов");
        System.out.println("\nИтого, в данном тесте LinkedList выигрывает в номинациях:" +
                "\nПервые 50000 элементов добавлены быстрее на " + (t1 - t4) + "мс" +
                "\nОставшиеся 50000 элементов добавлены быстрее на " + (t2 - t5) + "мс" +
                "\nИ, в целом, на добавление 100000 элементов потребовалось на " + (t3 - t6) + "мс меньше");
    }


    private  void test1() {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long t1 = 0; // количество миллисекунд, за которое в ArrayList обработали первую половину элементов
        long t2 = 0; // количество миллисекунд, за которое в ArrayList обработали вторую половину элементов
        long t3 = 0; // количество миллисекунд, за которое в ArrayList обработали все элементы
        long t4 = 0; // количество миллисекунд, за которое в LinkedList обработали первую половину элементов
        long t5 = 0; // количество миллисекунд, за которое в LinkedList обработали вторую половину элементов
        long t6 = 0; // количество миллисекунд, за которое в LinkedList обработали все элементы


        long x1 = System.currentTimeMillis();
        long x2 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x2 = System.currentTimeMillis();
                t1 = x2 - x1;

                System.out.println("Первые 500000 элементов в ArrayList добавили за " + t1 + "мс");
            }

            list1.add(i);
        }

        long x3 = System.currentTimeMillis();
        t2 = x3 - x2;
        t3 = x3 - x1;

        System.out.println("Оставшиеся 500000 элементов в ArrayList добавили за " + t2 + "мс");
        System.out.println("Всего времени затрачено " + t3 + "мс на добавление в ArrayList 1млн элементов");

        long x4 = System.currentTimeMillis();
        long x5 = 0;

        for (int i = 0; i < 1000000; i++) {

            if (i == 500000) {

                x5 = System.currentTimeMillis();
                t4 = x5 - x4;

                System.out.println("\nПервые 500000 элементов в LinkedList добавили за " + t4 + "мс");
            }

            list2.add(i);
        }

        long x6 = System.currentTimeMillis();
        t5 = x6 - x5;
        t6 = x6 - x4;

        System.out.println("Оставшиеся 500000 элементов в LinkedList добавили за " + t5 + "мс");
        System.out.println("Всего времени затрачено " + t6 + "мс на добавление в LinkedList 1млн элементов");
        System.out.println("\nИтого, в данном тесте ArrayList выигрывает в номинациях:" +
                "\nПервые 500000 элементов добавлены быстрее на " + (t4 - t1) + "мс" +
                "\nОставшиеся 500000 элементов добавлены быстрее на " + (t5 - t2) + "мс" +
                "\nИ, в целом, на добавление 1млн элементов потребовалось на " + (t6 - t3) + "мс меньше");
    }
}
