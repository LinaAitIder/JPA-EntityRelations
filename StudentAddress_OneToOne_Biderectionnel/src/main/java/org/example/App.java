package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.InitialContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Student-Address-ONE_TO_ONE
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = new Student();
        student.setName("John");
        student.setMail("john@gmail.com");
        student.setCourse("Java");
        student.setYear(2020);
        Address address = new Address();
        address.setCity("New York");
        address.setState("NY");
        address.setStreet("123 Main Street");

        student.setAddress(address);
        em.persist(student);

        em.getTransaction().commit();
        em.close();


    }
}
