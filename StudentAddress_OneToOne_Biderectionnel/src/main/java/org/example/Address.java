package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="street")
    protected String street;
    @Column(name="city")
    protected String city;
    @Column(name="state")
    protected String state;

    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(){
        id = (Long) System.nanoTime();
    }

    //Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
