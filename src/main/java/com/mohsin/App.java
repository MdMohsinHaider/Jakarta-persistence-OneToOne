package com.mohsin;

import com.mohsin.dao.PersonPassportDao;
import com.mohsin.dao.PersonsPassportDao;
import com.mohsin.entity.Passport;
import com.mohsin.entity.Person;

import java.time.LocalDate;

/**
 * One To One Mapping JPA
 *
 */
public class App {

    public static void main( String[] args ) {
        PersonsPassportDao dao = new PersonPassportDao();
//        savePassport(dao);
//        savePerson(dao);
        getPassportByPersonId(dao);
        getPersonAndPassportByPersonId(dao);
//        savePersonPassport(dao);
    }

    public static void savePassport(PersonsPassportDao dao){
        Passport passport = dao.savePassportDao(new Passport(154,"India","Bihar,Muzaffarpur"));
        System.out.println(passport);
    }

    public static void savePerson(PersonsPassportDao dao){
        Person person = dao.savePersonDao(new Person(102,"Mohsin","mdmohsinhaider@gmail.com","Male", LocalDate.now()),154);
        System.out.println(person);
    }

    public static void getPassportByPersonId(PersonsPassportDao dao){
        Passport passport = dao.getPersonPassportByPersonIdDao(100);
        System.out.println(passport);
    }

    public static void getPersonAndPassportByPersonId(PersonsPassportDao dao){
        Person person = dao.getPersonAndPassportByPersonIdDao(100);
        System.out.println(person); // Person{personDetailsOnly, passport=Passport{PassportDetailsOnly}}
        System.out.println(person.getPassport()); // Passport{PassportDetailsOnly}
    }

    public static void savePersonPassport(PersonsPassportDao dao){
        Person person = dao.savePersonPassportDao(
                new Passport(500,"India","Bihar muzaffarpur 843108"),
                new Person(501,"Md Mohsin Haider","mdmohsinhaider@gmail.com","male",LocalDate.now())
        );
        System.out.println(person);
    }
}


