
package ar.com.yoprogramo.api.controllers;

import ar.com.yoprogramo.api.dto.Message;
import ar.com.yoprogramo.api.dto.PersonDto;
import ar.com.yoprogramo.api.models.Person;
import ar.com.yoprogramo.api.services.PersonService;
import java.util.ArrayList;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/person")
//para no poner la url larga de los endpoints

public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("/all")
    public ArrayList<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    
    @PostMapping("/newperson")
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
    
    
    @GetMapping("/getpersonbyid/{id}")
    public Person getPersonByID(@PathVariable("id") Long id){
        return personService.getPersonByID(id);
    }
    
    @GetMapping("/getperson/query")
    public ArrayList<Person>getPersonByApellido(@RequestParam("apellido") String apellido){
        return personService.getPersonByApellido(apellido); 
    }
    @DeleteMapping("/{id}")
    public String removePerson(@PathVariable("id") Long id){
        if(personService.removePerson(id)){
            return "Se eliminó a la persona de id "+ id+ " correctamente";
        }else{
            return "La persona no existe o no pudo ser eliminada.";
        }
    }
   
    //Hernan
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person personTochange) {

        Person p = personService.findById(id);
        personTochange.setId(p.getId());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(personTochange, p);
        return personService.savePerson(p);
    }
    
}
