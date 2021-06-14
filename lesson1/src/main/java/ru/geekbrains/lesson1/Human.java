package ru.geekbrains.lesson1;

public class Human {
    private String name;
    private int restrictionRun = 10;
    private int restrictionJump = 2;

    public Human(String name) {
        this.name = name;
    }

    public int getRestrictionJump() {
        return restrictionJump;
    }

    public int getRestrictionRun() {
        return restrictionRun;
    }

    public void run() {
        System.out.println("Человек " + name + " бежит " + restrictionRun);
    }

    public void jump() {
        System.out.println("Человек " + name + " прыгает " + restrictionJump);
    }
}
