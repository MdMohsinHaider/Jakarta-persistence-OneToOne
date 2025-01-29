package com.mohsin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {
    @Id
    private int id;
    private String name;
    private String email;
    private String gender;
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    public Person(int id, String name, String email, String gender, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", passport=" + passport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(gender, person.gender) && Objects.equals(dob, person.dob) && Objects.equals(passport, person.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, gender, dob, passport);
    }
}
