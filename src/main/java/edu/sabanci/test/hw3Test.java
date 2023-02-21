package edu.sabanci.test;

import edu.sabanci.model.*;
import jakarta.persistence.EntityManager;
import edu.sabanci.utility.EntityManagerUtils;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class hw3Test {
    public static void main(String[] args) {
        saveTestData();
    }

    private static void saveTestData() {
        Date date1=new Date(99, Calendar.JULY,30);
        Date date2=new Date(99, Calendar.OCTOBER,14);
        Date date3=new Date(99, Calendar.NOVEMBER,12);

        Student student1 = new Student("Hasan Furkan", "Coskun", Gender.MALE, "Çeliktepe",date1);
        Student student2 = new Student("Özgür Deniz", "Topçuoğlu", Gender.MALE, "Çeliktepe",date2);
        Student student3 = new Student("Hilal", "Kökçü", Gender.FEMALE, "Manisa",date3);

        Course course1 = new Course("IT554","Enterprise Java",90);
        Course course2 = new Course("IT550","Machine Learning",95);
        Course course3 = new Course("IT549","Python",100);
        Instructor ınstructor1= new PermanentInstructor("Ahmet","Demirelli","Istanbul","555",20000);
        Instructor ınstructor2= new PermanentInstructor("Altuğ","Tanaltay","Istanbul","554",20000);
        Instructor ınstructor3= new VisitingInstructor("Koray","Güney","Istanbul","552",700);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        course1.setInstructor(ınstructor3);
        course2.setInstructor(ınstructor2);
        course3.setInstructor(ınstructor1);

//        student1.getCourseList().add(course1);
//        student1.getCourseList().add(course2);
//        student1.getCourseList().add(course3);
        course1.setStudentList(studentList);
//        student2.getCourseList().add(course1);
//        student3.getCourseList().add(course1);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(ınstructor1);
            entityManager.persist(ınstructor2);
            entityManager.persist(ınstructor3);
            entityManager.getTransaction().commit();
            System.out.println("All data persisted!...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
