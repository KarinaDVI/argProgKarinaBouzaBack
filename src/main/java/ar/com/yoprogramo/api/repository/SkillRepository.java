
package ar.com.yoprogramo.api.repository;


import ar.com.yoprogramo.api.models.Skill;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
    public abstract ArrayList<Skill> findByName(String name);

    public Skill getByName(String name);

    public List<Skill> findAllByPersonId(Long personId);
}
