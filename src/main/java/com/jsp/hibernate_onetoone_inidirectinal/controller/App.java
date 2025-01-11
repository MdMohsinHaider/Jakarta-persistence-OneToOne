package com.jsp.hibernate_onetoone_inidirectinal.controller;

import java.time.LocalDate;
import java.util.Random;

import com.jsp.hibernate_onetoone_inidirectinal.dao.PersonAadharDao;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Person;

/**
 * Hello world!
 */
public class App {
	
    public static void main(String[] args) {
    	Random random = new Random();
    	long number = 100000000000L + (long)(random.nextDouble() * 900000000000L);
    	
    	PersonAadharDao aadharDao = new PersonAadharDao();
        Aadhar aadhar = new Aadhar(number,"haish", LocalDate.parse("1947-08-10"),"ABC Adresess");
//        Person person =  new Person(101,"james","jemes@gmail.com",91983774,aadhar);
        Person person2 = new Person();
        person2.setName("Abcds");
        person2.setEmail("Abcd@gmail.com");
        person2.setPhone(916476785);
        person2.setAadhar(aadhar);
        
        aadharDao.savePersonAadharDao(person2);  
        
        
        GetPersonById byId = new GetPersonById();
    }
}
