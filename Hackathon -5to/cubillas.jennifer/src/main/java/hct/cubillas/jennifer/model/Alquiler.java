package hct.cubillas.jennifer.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "alquiler")
@Data @NoArgsConstructor @AllArgsConstructor
public class Alquiler {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Long cliente_id;
    private Integer dias;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double total;
    private String estado;
}

