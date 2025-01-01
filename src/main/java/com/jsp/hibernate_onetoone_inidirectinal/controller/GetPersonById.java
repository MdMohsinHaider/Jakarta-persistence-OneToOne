package com.jsp.hibernate_onetoone_inidirectinal.controller;

import com.jsp.hibernate_onetoone_inidirectinal.dao.PersonAadharDao;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Aadhar;
import com.jsp.hibernate_onetoone_inidirectinal.entity.Person;

public class GetPersonById {
	public static void main(String[] args) {
		PersonAadharDao aadharDao = new PersonAadharDao();
		
//		Person person = aadharDao.getPersonByIdDao(10);
//		
//		if (person!=null) {
//			System.out.println(person);
//			
//			Aadhar aadhar = person.getAadhar();
//			if (aadhar !=null) {
//				System.out.println(aadhar);
//			}
//			else {
//				System.out.println("no aadhar associated with this person");
//			}
//		}
//		else {
//			System.out.println("given Person Id Not Found");
//		}
		
		boolean b = aadharDao.deleteAdharByPersonByIdDao(10);
		String msg = b?"deleted":"not deleted";
		System.out.println(msg);
	}

}
