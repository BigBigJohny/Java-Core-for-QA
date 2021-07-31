package ru.geekbrains.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Course> courses1 = new ArrayList<>(Arrays.asList(
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course1"),
                new Course("Course2")
        ));

        List<Course> courses2 = new ArrayList<>(Arrays.asList(
                new Course("Course1"),
                new Course("Course22"),
                new Course("Course3"),
                new Course("Course4"),
                new Course("Course44"),
                new Course("Course6"),
                new Course("Course557")
        ));

        List<Course> courses3 = new ArrayList<>(Arrays.asList(
                new Course("Course5570")
        ));

        List<Course> courses4 = new ArrayList<>(Arrays.asList(
                new Course("Course6"),
                new Course("Course55799")
        ));

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Bob", courses1),
                new Student("Jack", courses2),
                new Student("ALex",courses3),
                new Student("Mark",courses4)
        ));

        System.out.println(uniqueCourses(students));
        System.out.println(curiousStudents(students));
        System.out.println(studentsFromCourse(students,new Course("Course1")));
    }

    public static List<String> uniqueCourses(List<Student> students){
        List<String> courses = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getCourses().size(); j++) {
                courses.add(students.get(i).getCourses().get(j).getCourseName());
            }
        }
        List<String> uniqueCourses = courses.stream()
                .distinct().collect(Collectors.toList());
        return uniqueCourses;
    }

    public static List<String> curiousStudents(List<Student> students){
        List<String> nameCuriousStudents = students.stream()
                .sorted((s1, s2) -> s1.getCourses().size() + s2.getCourses().size())
                .limit(3)
                .map((Function<Student, String>) studentName -> studentName.getName())
                .collect(Collectors.toList());
        return nameCuriousStudents;
    }

    public static List<String> studentsFromCourse(List<Student>students, Course course){
        List<String> nameStudentsCourse = students.stream()
                .filter(student -> student.getCourses().stream().anyMatch(c -> c.getCourseName().equals(course.getCourseName())))
                .map((Function<Student, String>) studentName -> studentName.getName())
                .collect(Collectors.toList());
        return nameStudentsCourse;
    }
}
