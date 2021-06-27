package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box() {
        list = new ArrayList<T>();
    }

    public List<T> getList() {
        return list;
    }

    public void add(T obj) {
        list.add(obj);
    }

    public float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    public void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveAt(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

}
