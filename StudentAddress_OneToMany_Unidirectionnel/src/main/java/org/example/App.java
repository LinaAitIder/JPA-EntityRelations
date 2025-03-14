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
        student1.setMail("john@gmail.com");
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

        student1.getAddresses().add(address1);
        student1.getAddresses().add(address2);
        em.getTransaction().begin();
        em.persist(address1);
        em.persist(address2);
        em.persist(student1);
        em.getTransaction().commit();
        em.close();
        emf.close();





    }
}
