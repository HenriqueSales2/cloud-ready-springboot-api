package br.com.application.controllers.person;

import br.com.application.data.dto.PersonDTO;
import br.com.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service; // com a dependência Service
    // private PersonService service =  new PersonService(); sem a dependência Service


    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        var person = service.findById(id);
        person.setBirthDay(new Date()); // eu setei a data do dia em que você for executar o código
        //person.setPhoneNumber("+55 (11) 99999-9999");
        person.setPhoneNumber(""); // setei um campo vazio para testar o "@JsonInclude" do campo "phoneNumber" no PersonDTO
        person.setLastName(null); // setei um campo nulo para testar o "@JsonInclude" do campo "last_name" no PersonDTO
        person.setSensitiveData("Foo Bar"); // setei um texto qualquer para este campo que é um dado sensível,
        // ou seja, ele não vai aparecer na consulta do JSON no Postman ou alguma outra plataforma que você esteja usando

        return person;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {
        return service.findAll();
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return service.create(personDTO);
    }


    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return service.update(personDTO);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
