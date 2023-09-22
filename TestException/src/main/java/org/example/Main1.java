package org.example;

import java.util.ArrayList;

/**
 * Представим, что у нас есть ArrayList, в который нельзя добавлять больше чем 10 элементов.
 * Нужно разработать свой собственный класс исключения (наследник от Exception), которое будет выкидываться при попытке добавления 11го элемента.
 * В данном классе постараться переопределить как можно больше методов класса Throwable.
 */

public class Main1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            for (int i = 0; i < 20; i++) {

                if (arrayList.size() > 10) {

                    throw new ArraySizeException();
                }

                arrayList.add(i);
            }
        } catch (ArraySizeException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}