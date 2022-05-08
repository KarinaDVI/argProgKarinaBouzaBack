
package ar.com.yoprogramo.api.services;

import ar.com.yoprogramo.api.models.Experience;
import ar.com.yoprogramo.api.repository.ExperienceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    public ArrayList<Experience> getAllEducation() {
        return (ArrayList<Experience>) experienceRepository.findAll();
    }

    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience getEducationByID(Long id) {
        return experienceRepository.findById(id).get();
    }

    public boolean deleteById(Long id) {
        try {
            experienceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Experience> getEducationByPersonId(Long personId) {
           return experienceRepository.findAllByPersonId(personId);
    }

}
