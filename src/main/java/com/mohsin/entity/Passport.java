package com.mohsin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Passport {
    @Id
    private int id;
    private String countryName;
    private String address;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && Objects.equals(countryName, passport.countryName) && Objects.equals(address, passport.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName, address);
    }
}
