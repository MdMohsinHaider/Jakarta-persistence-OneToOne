package com.jsp.hibernate_onetoone_inidirectinal.dao;

import java.util.List;

import com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PersonAadharDao {
	
	EntityManager em = Persistence.createEntityManagerFactory("hibernate-a5").createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	// Insert Person
	public Person savePersonAadharDao(Person person) {
		try {
			et.begin();
			em.persist(person);
//			em.persist(aadhar);
			et.commit();
			return person;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	// get Person by ID
	public Person getPersonByIdDao(int personId) {
		return em.find(Person.class, personId);
	}
	
	
	// delete Aadhar by Person Id 
	public boolean deleteAdharByPersonByIdDao(int personId) {
		Person person = em.find(Person.class, personId);
		if (person!=null) {
			Aadhar aadhar =person.getAadhar();
			if(aadhar!=null) {
				person.setAadhar(null);
				et.begin();
				em.merge(person);
				em.remove(aadhar);
				et.commit();
				return true;
				
			}
			else {
				return false;
			}
		}
		else return false;
	}
	
	List<Person> getAllPersonAdharDao(){
		return em.createQuery("from Person",Person.class).getResultList();
	}
}
