package ru.geekbrains.lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String[] arr = {"test1", "test2", "test3", "123456"};
        Integer[] arr = {9, 7, 21, 321, -9, 0};

        System.out.println("Задача 1\n" + Arrays.toString(arr));
        swapElements(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------------------");

        System.out.println("Задача 2");
        Orange orange = new Orange();
        Apple apple = new Apple();

        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();

        for (int i = 0; i < 5; i++) {
            orangeBox1.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 9; i++) {
            appleBox.add(new Apple());
        }

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        System.out.println("Вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес коробки 2 с апельсинами: " + orangeBox2.getWeight());
        System.out.println("Вес коробки  с яблоками: " + appleBox.getWeight());

        System.out.println("Сравнить вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Сравнить вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox));
        System.out.println("Сравнить вес orangeBox1 и orangeBox2: " + orangeBox1.compare(orangeBox2));

        orangeBox1.moveAt(orangeBox2);
        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
