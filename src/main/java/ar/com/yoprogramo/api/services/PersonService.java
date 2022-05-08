package ar.com.yoprogramo.api.services;

import ar.com.yoprogramo.api.models.Person;
import ar.com.yoprogramo.api.repository.PersonRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public ArrayList<Person> getAllPersons() {
        return (ArrayList<Person>) personRepository.findAll();
    }

    public Person savePerson(Person persona) {
        return personRepository.save(persona);
    }

    //Ver porque antes no tenia el .get()
    public Person getPersonByID(Long id) {
        return personRepository.findById(id).get();
    }

    public ArrayList<Person> getPersonByApellido(String apellido) {
        return personRepository.findByApellido(apellido);
    }

    public boolean removePerson(Long id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //mio
    public Person findPerson(Long id) {
        Person perso = personRepository.findById(id).orElse(null);
        return perso;
    }

    //de ManyToOne Hernan
    public Person findById(Long personId) {
        return personRepository.findById(personId).get();
    }
}
