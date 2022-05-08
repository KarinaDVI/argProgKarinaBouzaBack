
package ar.com.yoprogramo.api.repository;


import ar.com.yoprogramo.api.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
