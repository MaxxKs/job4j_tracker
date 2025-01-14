package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
     Student student = new Student();
     student.setFullName("Ivanov Ivan Ivanovich");
     student.setGroup(3);
     student.setDateEnrollment(new Date());

        System.out.println(student.getFullName() + " — group: " + student.getGroup() + ", date of enrollment: " + student.getDateEnrollment());
    }
}
