package hct.cubillas.jennifer.rest;
import hct.cubillas.jennifer.model.Cliente;
import hct.cubillas.jennifer.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/v1/api/cliente")
@RequiredArgsConstructor @Slf4j
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getInfo() {
        Map<String, Object> r = new HashMap<>();
        r.put("tipo_documento", "DNI");
        r.put("numero_documento", "72550711");
        r.put("nombre", "Jennifer");
        r.put("apellido", "Cubillas");
        r.put("celular", "987654321");
        r.put("correo", "jennifer.cubillas@gmail.com");
        r.put("licencia", "A123341");
        r.put("estado", "A");
        log.info("[INVOCAR] GET /v1/api/cliente");
        return ResponseEntity.ok(r);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente c) {
        return ResponseEntity.status(201).body(service.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente c) {
        return ResponseEntity.ok(service.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


