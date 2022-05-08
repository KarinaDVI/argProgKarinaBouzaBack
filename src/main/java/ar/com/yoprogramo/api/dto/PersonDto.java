
package ar.com.yoprogramo.api.dto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDto {
    @NotBlank
    private String nombre;
    private String apellido;
    private int edad;
    private String urlImage;
    private String seniority;
    private String company;
    private String position;
    private String abouts;

    public PersonDto() {
    }

    public PersonDto(@NotBlank String nombre, String apellido, int edad, String urlImage, String seniority, String company, String position, String abouts) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.urlImage = urlImage;
        this.seniority = seniority;
        this.company = company;
        this.position = position;
        this.abouts = abouts;
    }

    
}
