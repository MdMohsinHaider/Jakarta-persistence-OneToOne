package com.mohsin.dao;

import com.mohsin.entity.Passport;
import com.mohsin.entity.Person;

/**
 * <h1>PersonPassportDao Interface</h1>
 * This interface defines operations for managing Person and Passport entities.
 * It provides methods for saving and retrieving Passport and Person data.
 * Implementing classes should handle transactions appropriately.
 *
 * <p><strong>Operations included:</strong></p>
 * <ul>
 *     <li>Save a new Passport</li>
 *     <li>Save a new Person with an existing Passport</li>
 *     <li>Retrieve a Passport using a Person ID</li>
 *     <li>Retrieve a Person and Passport using a Person ID</li>
 *     <li>Save both a new Person and Passport together</li>
 * </ul>
 *
 * @author Md Mohsin Haider
 * @version 1.0
 * @since 2024
 */
public interface PersonsPassportDao {
    /**
     * <h2>1. Save Passport</h2>
     * Persists a new Passport entity in the database.
     *
     * @param passport The Passport entity to be saved.
     * @return The saved Passport object, or {@code null} if an error occurs.
     */
    Passport savePassportDao(Passport passport);

    /**
     * <h2>2. Save Person with Existing Passport</h2>
     * Saves a new Person entity and associates it with an existing Passport.
     *
     * @param person The Person entity to be saved.
     * @param passportId The ID of the existing Passport in the database.
     * @return The saved Person object with the associated Passport, or {@code null} if an error occurs.
     */
    Person savePersonDao(Person person, int passportId);

    /**
     * <h2>3. Get Passport by Person ID</h2>
     * Retrieves the Passport associated with a given Person ID.
     *
     * @param personId The ID of the Person whose Passport is to be retrieved.
     * @return The associated Passport, or {@code null} if no Passport is found.
     */
    Passport getPersonPassportByPersonIdDao(int personId);

    /**
     * <h2>4. Get Person and Passport by Person ID</h2>
     * Retrieves a Person along with their associated Passport using the Person ID.
     *
     * @param personId The ID of the Person to be retrieved.
     * @return The Person entity, including Passport details if available, or {@code null} if not found.
     */
    Person getPersonAndPassportByPersonIdDao(int personId);

    /**
     * <h2>5. Save New Person and Passport</h2>
     * Saves both a new Passport and a new Person in the database.
     * Ensures that neither the Passport nor the Person exists prior to saving.
     *
     * @param passport The new Passport entity to be saved.
     * @param person The new Person entity to be saved.
     * @return The saved Person entity with the associated Passport, or {@code null} if an error occurs.
     */
    Person savePersonPassportDao(Passport passport, Person person);
}
