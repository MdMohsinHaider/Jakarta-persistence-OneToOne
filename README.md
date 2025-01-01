# Jakarta Persistence @OneToOne Relationship

This project demonstrates how to implement a unidirectional `@OneToOne` relationship using Jakarta Persistence (formerly JPA). The example covers entity mapping, persistence configuration, and basic CRUD operations.

---

## Prerequisites

To run this project, you need the following:

- Java 8 or later
- Maven or Gradle
- An SQL database (e.g., MySQL, PostgreSQL, H2, etc.)
- An IDE like IntelliJ IDEA or Eclipse
- Jakarta Persistence or JPA-compatible library

---

## Project Setup

### Dependencies
Add the following dependencies to your `pom.xml` (for Maven):

```xml
<dependencies>
    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.2.9.Final</version>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.1.214</version>
    </dependency>
</dependencies>
```

For Gradle:

```groovy
dependencies {
    implementation 'jakarta.persistence:jakarta.persistence-api:3.1.0'
    implementation 'org.hibernate:hibernate-core:6.2.9.Final'
    implementation 'com.h2database:h2:2.1.214'
}
```

### Database Configuration
Configure your database connection in `persistence.xml`:

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_1.xsd"
             version="3.1">

    <persistence-unit name="examplePU">
        <class>com.jsp.hibernate_onetoone_inidirectinal.entity.Person</class>
        <class>com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="sa"/>
            <property name="jakarta.persistence.jdbc.password" value=""/>

            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

---

## Entity Classes

### Aadhar Entity
```java
package com.jsp.hibernate_onetoone_inidirectinal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aadhar {
    @Id
    private long aadharNumber;
    private String fatherName;
    private LocalDate dob;
    private String address;
}
```

### Person Entity
```java
package com.jsp.hibernate_onetoone_inidirectinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long phone;

    @OneToOne
    private Aadhar aadhar;
}
```

---

## Main Application

### Example Usage
```java
package com.jsp.hibernate_onetoone_inidirectinal;

import com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Main application to demonstrate @OneToOne relationship
public class Main {
    public static void main(String[] args) {
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
        EntityManager em = emf.createEntityManager();

        // Start transaction
        em.getTransaction().begin();

        // Create a new Aadhar
        Aadhar aadhar = new Aadhar(123456789012L, "John's Father", LocalDate.of(1980, 1, 1), "123 Main St");

        // Create a new Person
        Person person = new Person();
        person.setName("John Doe");
        person.setEmail("john.doe@example.com");
        person.setPhone(9876543210L);
        person.setAadhar(aadhar);

        // Persist the Person (Aadhar will be persisted due to cascading)
        em.persist(person);

        // Commit transaction
        em.getTransaction().commit();

        // Retrieve and print the Person
        Person retrievedPerson = em.find(Person.class, person.getId());
        System.out.println("Retrieved Person: " + retrievedPerson.getName());
        System.out.println("Aadhar Number: " + retrievedPerson.getAadhar().getAadharNumber());

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}
```

---

## Running the Application

1. Clone or download the repository.
2. Build the project using Maven or Gradle.
3. Run the `Main` class.
4. Observe the console logs to see the relationship in action.

---

## Key Annotations

- `@Entity`: Marks the class as a JPA entity.
- `@Id`: Specifies the primary key.
- `@GeneratedValue`: Configures the generation strategy for primary keys.
- `@OneToOne`: Specifies a one-to-one relationship between two entities.
- `@Data`: Lombok annotation to generate getters, setters, `toString`, and more.
- `@AllArgsConstructor` / `@NoArgsConstructor`: Lombok annotations for generating constructors.

---

## License
This project is open source and available under the [MIT License](LICENSE).
