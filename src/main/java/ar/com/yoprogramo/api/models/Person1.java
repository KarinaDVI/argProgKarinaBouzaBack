
package ar.com.yoprogramo.api.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter 
@Entity
//si el nombre de la tabla no se llama igual 
//que el modelo/tabla se aclara

@Table(name="person_table")
public class Person1 {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    //Se pone column para poder definir un tamaño maximo para el dato
    //de una url (string con varchar tiene de maximo 255)
    
    private String nombre;
    private String apellido;
    private int edad;
    private String seniority;
    private String company;
    private String position;
    private String abouts;
    
    @Column(name="url_imagen",length=2048)
    private String urlImage;

    
@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    List<Skill> skill = new ArrayList<>();

}
