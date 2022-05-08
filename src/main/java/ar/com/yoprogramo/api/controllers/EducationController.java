package ar.com.yoprogramo.api.controllers;

import ar.com.yoprogramo.api.models.Education;
import ar.com.yoprogramo.api.models.Person;
import ar.com.yoprogramo.api.repository.EducationRepository;
import ar.com.yoprogramo.api.repository.PersonRepository;
import ar.com.yoprogramo.api.services.EducationService;
import ar.com.yoprogramo.api.services.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    PersonService personService;

    @Autowired
    EducationService educationService;
    //mio
  
    @GetMapping("/getall")
    public ResponseEntity<List<Education>> getAllEducation() {
        List<Education> educationList = educationService.getAllEducation();
        return new ResponseEntity<>(educationList, HttpStatus.OK);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable(value = "id") Long id) {
        Education education = educationService.getEducationByID(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @GetMapping("/person/{person_id}")
    public ResponseEntity<List<Education>> getAllEducationByPersonId(@PathVariable(value = "person_id") Long personId) {
        List<Education> educationList = new ArrayList<>();
        if (personService.getPersonByID(personId) != null) {
            educationList = educationService.getEducationByPersonId(personId);
            return new ResponseEntity<>(educationList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(educationList, HttpStatus.NOT_FOUND);
        }
    }
    
    //De Hernan2
    @PostMapping("/person/{person_id}")
    public ResponseEntity<Education> createEducation(@PathVariable(value = "person_id") Long personId, 
            @RequestBody Education educationRequest) {
        Person p = personService.findById(personId);
        educationRequest.setPerson(p);
        Education newEducation = educationService.save(educationRequest);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
     
    //Usar: Hernan nuevo
    
   @PutMapping("/{id}")
    public ResponseEntity<Education> updateComment(@PathVariable("id") Long id, @RequestBody Education educationRequest) {
        Education education = educationService.getEducationByID(id);
        // .orElseThrow(() -> new ResourceNotFoundException("EducationId " + id + "not found"));
        education.setPerson(educationRequest.getPerson());
        educationRequest.setId(education.getId());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(educationRequest, education);

        return new ResponseEntity<>(educationService.save(education), HttpStatus.OK);
    }
    
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable("id") Long id, @RequestBody Education educationRequest) {
        Education education = educationService.getEducationByID(id);
        // .orElseThrow(() -> new ResourceNotFoundException("EducationId " + id + "not found"));
        //mio
        education.setTitle(educationRequest.getTitle());
        education.setDescription(educationRequest.getDescription());
        //Hernan/
        /*Creo que hay que poner toda la persona porque es propio del metodo.
        Preguntar si en angular para hacer put habrá que traer también 
        los campos de persona en el formulario*/
        education.setPerson(educationRequest.getPerson());
        return new ResponseEntity<>(educationService.save(education), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEducation(@PathVariable("id") Long id) {
        educationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
