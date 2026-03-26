package br.com.application.service;

import br.com.application.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // serve para injetar dependências sem ficar dando "new Objeto" por exemplo
public class PersonService {

    private final AtomicLong counter = new AtomicLong(); // vamos mocar um id, pois ainda não irei utilizar banco de dados nesse projeto

    private Logger logger = Logger.getLogger(PersonService.class.getName()); // logar informações importantes do projeto



    public List<Person> findAll() {
        logger.info("Finding all People!");
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("User");
        person.setLastName("UserLastName");
        person.setAddress("UserAddress");
        person.setGender("Male");
        return person;

    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name: " + i);
        person.setLastName("Last Name: " + i);
        person.setAddress("Some address in Brazil");
        person.setGender("Female");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return person;

    }

    public Person update(Person person) {
        logger.info("Creating one Person!");
        return person;

    }

    public void delete(String id) {
        logger.info("Delete one Person!");

    }
}
