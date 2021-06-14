package ru.geekbrains.lesson1;

public class Cat {
    private String name;
    private int restrictionRun = 3;
    private int restrictionJump = 1;

    public Cat(String name) {
        this.name = name;
    }

    public int getRestrictionJump() {
        return restrictionJump;
    }

    public int getRestrictionRun() {
        return restrictionRun;
    }

    public void run() {
        System.out.println("Кот " + name + " бежит " + restrictionRun);
    }

    public void jump() {
        System.out.println("Кот " + name + " прыгает " + restrictionJump);
    }
}
