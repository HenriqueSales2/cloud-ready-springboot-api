package br.com.application.service;

import br.com.application.controllers.person.TestLogController;
import br.com.application.data.dto.PersonDTO;
import br.com.application.exception.ResourceNotFoundException;
import static br.com.application.mapper.ObjectMapper.parseObject;
import static br.com.application.mapper.ObjectMapper.parseListObjects;
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


    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObjects(repository.findAll(), PersonDTO.class); // retornando uma lista de entidades
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        return parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!");
        var entity = parseObject(personDTO, Person.class); // fazendo a conversão de PersonDTO para Person
        return parseObject(repository.save(entity), PersonDTO.class); // convertendo em DTO, criando, e salvando a entidade
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Creating one Person!");
        Person oldPerson = repository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        oldPerson.setFirstName(personDTO.getFirstName());
        oldPerson.setLastName(personDTO.getLastName());
        oldPerson.setAddress(personDTO.getAddress());
        oldPerson.setGender(personDTO.getGender());

        var entity = repository.save(oldPerson);
        return parseObject(entity, PersonDTO.class); // convertendo em DTO, atualizando, e salvando a entidade
    }

    public void delete(Long id) {
        logger.info("Delete one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        repository.delete(entity);

    }
}
