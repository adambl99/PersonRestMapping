package adam.controller;
import adam.exception.ResourceNotFoundException;
import adam.model.Greeting;
import adam.model.Person;
import adam.service.PersonService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PersonController {

    private PersonService pService;

    public PersonController(PersonService pService) {
        this.pService = pService;
    }

    @GetMapping("/persons")
    public ResponseEntity<Set<Person>> getPersons(){
    return new ResponseEntity<>(pService.findall(), HttpStatus.OK);
    }

        @PostMapping("/addperson")
        public ResponseEntity<Set<Person>> addPerson(Person name){
            System.out.println("added User " + name.getName());
            pService.save(name);
            return new ResponseEntity<>(pService.findall(), HttpStatus.OK);
    }
        @DeleteMapping("/delete")
        public ResponseEntity<Set<Person>> deletePerson(Person name){
            System.out.println("deleted user " + name.getName());
            pService.deleteById(name.getId());
        return new ResponseEntity<>(pService.findall(), HttpStatus.OK);
    }
    @PutMapping("/edit")
    public ResponseEntity<Set<Person>> updatePerson(Long id, Person name){
        Person updatePerson = pService.findbyId(id).orElseThrow(() -> new ResourceNotFoundException("No one exists with id: " + id));
        updatePerson.setName(name.getName());
        pService.save(updatePerson);
        System.out.println("edited user " + updatePerson.getName());
        return new ResponseEntity<>(pService.findall(), HttpStatus.OK);

    }
}
