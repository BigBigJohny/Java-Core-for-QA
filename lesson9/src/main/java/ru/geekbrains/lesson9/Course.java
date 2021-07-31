package ru.geekbrains.lesson9;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
