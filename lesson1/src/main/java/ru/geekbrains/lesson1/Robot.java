package ru.geekbrains.lesson1;

public class Robot {
    private String name;
    private int restrictionRun = 15;
    private int restrictionJump = 3;

    public Robot(String name) {
        this.name = name;
    }

    public int getRestrictionJump() {
        return restrictionJump;
    }

    public int getRestrictionRun() {
        return restrictionRun;
    }

    public void run() {
        System.out.println("Робот " + name + " бежит " + restrictionRun);
    }

    public void jump() {
        System.out.println("Робот " + name + " прыгает " + restrictionJump);
    }
}
