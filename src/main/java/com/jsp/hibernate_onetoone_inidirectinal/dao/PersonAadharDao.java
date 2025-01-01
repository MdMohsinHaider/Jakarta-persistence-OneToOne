package com.jsp.hibernate_onetoone_inidirectinal.dao;

import com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAadharDao {
	
	EntityManager em = Persistence.createEntityManagerFactory("hibernate-a5").createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Person savePersonAadharDao(Person person, Aadhar aadhar) {
		try {
			et.begin();
			em.persist(person);
			em.persist(aadhar);
			et.commit();
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Person getPersonByIdDao(int personId) {
		return em.find(Person.class, personId);
	}
	
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
}
