package hct.cubillas.jennifer.service;
import hct.cubillas.jennifer.model.Alquiler;
import hct.cubillas.jennifer.repository.AlquilerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
@RequiredArgsConstructor 
@Slf4j
public class AlquilerService {
    private final AlquilerRepository repository;

    public List<Alquiler> findAll() {
        log.info("[INVOCAR] Listando alquileres desde la base de datos");
        return repository.findAll();
    }
    public Alquiler save(Alquiler a) {

        log.info("[REGISTRAR] {} {}", a.getDias(), a.getFechaInicio());
        return repository.save(a);
    }
    public Alquiler update(Long id, Alquiler details) {
        Alquiler a = repository.findById(id).orElseThrow();
        a.setDias(details.getDias());
        a.setFechaInicio(details.getFechaInicio());
        a.setFechaFin(details.getFechaFin());
        a.setTotal(details.getTotal());
        a.setEstado(details.getEstado());
        log.info("[ACTUALIZAR] ID: {}", id);
        return repository.save(a);
    }
    public void delete(Long id) {
        log.info("[ELIMINAR] ID: {}", id);
        repository.deleteById(id);
    }
}

