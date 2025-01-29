package com.mohsin.dao;

import com.mohsin.entity.Passport;
import com.mohsin.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonPassportDao implements PersonsPassportDao {

    EntityManager em = Persistence
            .createEntityManagerFactory("jpa-hibernate-mapping")
            .createEntityManager();
    EntityTransaction et = em.getTransaction();


    /**
     * <h1> 1.</h1>
     * Save Passport in databases.
     * @param passport pass the person data or Object
     * @return Passport
     */
    @Override
    public Passport savePassportDao(Passport passport){
        try {
            et.begin();
            em.persist(passport);
            et.commit();
            return passport;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (et.isActive()) {
                et.rollback();
            }
            return null;
        }
    }

    /**
     * <h1>2.</h1>
     * Save person with association with Passport.
     * @param person pass the person data or Object
     * @param passportId pass the passportId Which is exited already in Databases.
     * @return Person
     */
    @Override
    public Person savePersonDao(Person person, int passportId){
        try {
            // 1. Fetch the Passport entity from the database
            Passport passport = em.find(Passport.class,passportId);

            // 2. check passport is available in a database or not
            if (passport == null) {
                System.err.println("Passport not found with ID: " + passportId);
                return null;
            }

            // 3. Associate Passport with Person
            person.setPassport(passport);

            // 4. Persist Person entity
            et.begin();
            em.persist(person);
            et.commit();
            return person;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (et.isActive()) {
                et.rollback();
            }
            return null;
        }
    }


    /**
     * <h1>3.</h1>
     * Get a passport by using Person id.
     *
     * @param personId  for fetch passport by person id.
     * @return Passport
     */
    @Override
    public Passport getPersonPassportByPersonIdDao(int personId){
        try {
            // 1.Fetch the Person entity using personId
            Person person = em.find(Person.class, personId);

            // 2. Check person is available on not in databases
            if (person == null) {
                System.err.println("Person not found with ID: " + personId);
                return null;
            }

            // 3. Retrieve the associated Passport
            Passport passport = person.getPassport();

            // 4. Check person has passport is associated on not in databases.
            if (passport == null) {
                System.err.println("No passport associated with this person.");
                return null;
            }

            // 5. return passport
            return passport;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (et.isActive()) {
                et.rollback();
            }
            return null;
        }
    }


    /**
     * <h1>4.</h1>
     * Get a Person and passport by using Person id.
     *
     * @param personId  for fetch passport by this id.
     * @return Person with Password details
     */
    @Override
    public Person getPersonAndPassportByPersonIdDao(int personId){
        try {
            // 1.Fetch the Person entity using personId
            Person person = em.find(Person.class, personId);

            // 2. Check person is available on not in databases
            if (person == null) {
                System.err.println("Person not found with ID: " + personId);
                return null;
            }

            // 3. return passport
            return person;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (et.isActive()) {
                et.rollback();
            }
            return null;
        }
    }


    /**
     * <h1> 5.</h1>
     * Save new Passport as well as new Person at a time in databases.
     * And Passport doesn't exit as well as Person, Both are new
     * @param passport passing a Passport object.
     * @param person passing a Person object.
     * @return Person
     */
    @Override
    public Person savePersonPassportDao(Passport passport, Person person){
        try {
            // 1. Entity transaction begins
            et.begin();

            // 2. Persist the Passport first
            em.persist(passport);

            // 3. Associate the newly created Passport with the Person
            person.setPassport(passport);

            // 3. Persist the Person
            em.persist(person);

            // 4. Commit Transaction or save
            et.commit();

            // 5. return Person
            return person;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
