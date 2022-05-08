
package ar.com.yoprogramo.api.repository;


import ar.com.yoprogramo.api.models.Experience;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExperienceRepository extends JpaRepository<Experience, Long>{

    public List<Experience> findAllByPersonId(Long personId);
    
}
