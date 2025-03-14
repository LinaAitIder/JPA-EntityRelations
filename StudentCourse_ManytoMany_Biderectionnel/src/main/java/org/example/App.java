package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        //Adding Courses
        Course course1 = new Course();
        course1.setCourseName("JEE");

        Course course2 = new Course();
        course2.setCourseName("Management");

        //Adding students
        Student student1 = new Student();
        student1.setName("John");
        student1.setMail("JOHN@GMAIL.COM");
        student1.setYear(2020);
        student1.getCourses().add(course1);
        //student1.getCourses().add(course2);

        course1.getStudents().add(student1);
        //course2.getStudents().add(student1);
        //Adding Addresses
        Address address1 = new Address();
        address1.city = "New York";
        address1.state = "NY";
        address1.street ="3p-wallstreet";

        student1.setAddress(address1);
        em.getTransaction().begin();


        em.persist(student1);

        em.getTransaction().commit();


        em.close();
        emf.close();


    }
}
