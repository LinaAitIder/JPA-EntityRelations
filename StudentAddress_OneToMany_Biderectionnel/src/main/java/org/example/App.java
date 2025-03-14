package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        //Adding students
        Student student1 = new Student();
        student1.setName("John");
        student1.setMail("JOHN@GMAIL.COM");
        student1.setCourse("BSc");
        student1.setYear(2020);

        //Adding Addresses
        Address address1 = new Address();
        address1.city = "New York";
        address1.state = "NY";
        address1.street ="3p-wallstreet";

        Address address2 = new Address();
        address2.city = "Los Angeles";
        address2.street = "lk";
        address2.state = "CA";

        //Logically doesn't make sense (to set for each address students)
        address1.setStudent(student1);
        address2.setStudent(student1);
        student1.getAddresses().add(address1);
        student1.getAddresses().add(address2);
        em.getTransaction().begin();

        em.persist(student1);
        em.getTransaction().commit();
        em.close();
        emf.close();





    }
}
