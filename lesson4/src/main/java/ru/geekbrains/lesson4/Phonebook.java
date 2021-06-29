package ru.geekbrains.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private Map<String, String> phonebook;
    Phonebook() {
        phonebook = new HashMap<>();
    }
    public void add(String number, String surname) {
        phonebook.put(number, surname);
    }
    public void get(String surname){
        if(phonebook.containsValue(surname)) {
            Set<Map.Entry<String, String>> set = phonebook.entrySet();
            for (Map.Entry<String, String> temp : set) {
                if(temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + " - " + temp.getKey());
                }
            }
        } else {
            System.out.println(surname + " - такой фамилии нет в телефонном справочнике");
        }
    }
}
