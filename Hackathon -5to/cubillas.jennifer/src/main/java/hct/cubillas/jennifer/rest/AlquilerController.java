package hct.cubillas.jennifer.rest;
import hct.cubillas.jennifer.model.Alquiler;
import hct.cubillas.jennifer.service.AlquilerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/alquiler")
@RequiredArgsConstructor 
@Slf4j
@CrossOrigin(origins = "*")
public class AlquilerController {
    private final AlquilerService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getInfo() {
        Map<String, Object> r = new HashMap<>();
        r.put("dias", 9);
        r.put("fecha_inicio", "2023-10-01");
        r.put("fecha_fin", "2023-10-10");
        r.put("total", 500.0);
        r.put("estado", "A");
        log.info("[INVOCAR] GET /v1/api/alquiler");
        return ResponseEntity.ok(r);
    }

    @PostMapping
    public ResponseEntity<Alquiler> create(@RequestBody Alquiler c) {
        return ResponseEntity.status(201).body(service.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alquiler> update(@PathVariable Long id, @RequestBody Alquiler c) {
        return ResponseEntity.ok(service.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
