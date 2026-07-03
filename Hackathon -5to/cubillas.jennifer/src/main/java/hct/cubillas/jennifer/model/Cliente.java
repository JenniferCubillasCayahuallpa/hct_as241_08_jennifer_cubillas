package hct.cubillas.jennifer.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data @NoArgsConstructor @AllArgsConstructor
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String tipo_documento;
    private String numero_documento;
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;
    private String licencia;
    private String estado;
}

