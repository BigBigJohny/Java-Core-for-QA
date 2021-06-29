package ru.geekbrains.lesson4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Первое задание
        ArrayList<String> wordArray = new ArrayList<String>(
                Arrays.asList("Test", "Cat", "Dog", "Car", "Phone", "Employee", "Bag", "Cow", "Java", "Cat", "Array", "Lesson", "Test", "Java"));
        System.out.println(wordArray);

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : wordArray) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordsCount);

        Set<String> unique = new HashSet<>(wordArray);
        System.out.println(unique);
        System.out.println("----------------------------------------------------");

        //второе задание
        Phonebook phonebook = new Phonebook();

        phonebook.add("+79201233232", "Зобнин");
        phonebook.add("+79501233232", "Зобнин");
        phonebook.add("+79611233232", "Миранчук");
        phonebook.add("+79203333232", "Дзюба");
        phonebook.add("+79211233232", "Жирков");
        phonebook.add("+79031233232", "Жирков");

        phonebook.get("Зобнин");
        phonebook.get("Миранчук");
        phonebook.get("Дзюба");
        phonebook.get("Жирков");
        phonebook.get("Иванов");

    }
}
