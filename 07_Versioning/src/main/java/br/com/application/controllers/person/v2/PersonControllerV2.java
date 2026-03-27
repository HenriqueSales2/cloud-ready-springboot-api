package br.com.application.controllers.person.v2;

import br.com.application.data.dto.v1.PersonDTO;
import br.com.application.data.dto.v2.PersonDTOV2;
import br.com.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonService service; // com a dependência Service
    // private PersonService service =  new PersonService(); sem a dependência Service


    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOV2 findById(@PathVariable("id") Long id) {
        return service.findByIdV2(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV2> findAll() {
        return service.findAllV2();
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOV2 create(@RequestBody PersonDTOV2 personDTOV2) {
        return service.createV2(personDTOV2);
    }


    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOV2 update(@RequestBody PersonDTOV2 personDTOV2) {
        return service.updateV2(personDTOV2);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
