package hct.cubillas.jennifer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hct.cubillas.jennifer.model.Alquiler;



@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {}
