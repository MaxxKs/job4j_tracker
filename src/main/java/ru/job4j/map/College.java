package ru.job4j.map;

import java.util.Map;
import java.util.Set;
import java.util.Optional;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> (student.account().equals(account)))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        return findByAccount(account)
                .flatMap(student -> students.get(student)
                        .stream()
                        .filter(subject -> subject.name().equals(name))
                        .findFirst()
                );
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        college.findByAccount("000001")
                .ifPresent(element ->
                        System.out.println("Найденный студент: " + element));

        college.findBySubjectName("000001", "English")
                .ifPresent(subject ->
                        System.out.println("Оценка по найденному предмету: " + subject.score()));
    }
}
