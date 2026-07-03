package hct.cubillas.jennifer.service;

import hct.cubillas.jennifer.model.Cliente;
import hct.cubillas.jennifer.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Service @RequiredArgsConstructor @Slf4j
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> findAll() {
        log.info("[INVOCAR] Listando clientes");
        return repository.findAll();
    }
    public Cliente save(Cliente c) {

        log.info("[REGISTRAR] {} {}", c.getNombre(), c.getApellido());
        return repository.save(c);
    }
    public Cliente update(Long id, Cliente details) {
        Cliente c = repository.findById(id).orElseThrow();
        c.setTipo_documento(details.getTipo_documento());
        c.setNumero_documento(details.getNumero_documento());
        c.setNombre(details.getNombre());
        c.setApellido(details.getApellido());
        c.setCelular(details.getCelular());
        c.setCorreo(details.getCorreo());
        c.setLicencia(details.getLicencia());
        c.setEstado(details.getEstado());
        log.info("[ACTUALIZAR] ID: {}", id);
        return repository.save(c);
    }
    public void delete(Long id) {
        log.info("[ELIMINAR] ID: {}", id);
        repository.deleteById(id);
    }
}