package com.spring_boot_course;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;

    private String name;
    private Integer age;
    private String email;

    public Customer(String name,
                    Integer age,
                    String email,
                    Integer id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(age, customer.age) && Objects.equals(email, customer.email) && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
