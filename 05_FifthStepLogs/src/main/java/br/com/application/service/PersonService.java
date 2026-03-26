package br.com.application.service;

import br.com.application.controllers.person.TestLogController;
import br.com.application.exception.ResourceNotFoundException;
import br.com.application.model.Person;
import br.com.application.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service // serve para injetar dependências sem ficar dando "new Objeto" por exemplo
public class PersonService {

    private final AtomicLong counter = new AtomicLong(); // vamos mocar um id, pois ainda não irei utilizar banco de dados nesse projeto
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName()); // logar informações importantes do projeto

    @Autowired
    PersonRepository repository;


    public List<Person> findAll() {
        logger.info("Finding all People!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
    }


    public Person create(Person person) {
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Creating one Person!");
        Person oldPerson = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setAddress(person.getAddress());
        oldPerson.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        repository.delete(entity);

    }
}
