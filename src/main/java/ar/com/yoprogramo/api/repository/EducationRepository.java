package ar.com.yoprogramo.api.repository;

import ar.com.yoprogramo.api.models.Education;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {

    public List<Education> findAllByPersonId(Long personId);
   //public abstract ArrayList<Person> findByApellido(String apellido);


//De Hernan:
/*
public interface EducationRepository extends JpaRepository<Education, Long> {

    public List<Education> findAllByPersonId(Long personId);
   // public abstract ArrayList<Person> findByApellido(String apellido);
}
*/
}