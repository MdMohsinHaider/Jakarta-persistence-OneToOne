# JPA Unidirectional Mapping: Person & Passport

## Overview
This project demonstrates **JPA unidirectional mapping** between `Person` and `Passport`.
- Each **Person** has **one Passport**.
- The relationship is **unidirectional**, meaning only `Person` holds the reference to `Passport`, but not vice versa.

## Technologies Used
- Java 17+
- JPA (Jakarta Persistence API)
- Hibernate ORM
- H2 / MySQL Database
- Maven

## Entity Relationship
```
Person (1) ----> (1) Passport
```
- A **Person** has exactly **one Passport**.
- A **Passport** does not have a reference to `Person` (unidirectional).

## JPA Entity Mapping

### **Person.java**
```java
import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;
    
    // Getters & Setters
    public Passport getPassport() {
        return passport;
    }
    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
```

### **Passport.java**
```java
import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String country;
    
    // Getters & Setters
}
```

## How to Run
1. Clone this repository
2. Configure `persistence.xml` for database connection
3. Run the `PersonPassportDao` methods to test data persistence

## Example Usage
```java
Person person = new Person();
person.setName("John Doe");

Passport passport = new Passport();
passport.setNumber("A1234567");
passport.setCountry("USA");

person.setPassport(passport);

dao.savePersonPassportDao(passport, person);
```

## Notes
- Unidirectional mapping means **Passport does NOT know about Person**.
- `CascadeType.ALL` ensures that saving a `Person` also saves the associated `Passport`.
- `@JoinColumn(name = "passport_id")` specifies the foreign key column in the `Person` table.

## License
MIT License

