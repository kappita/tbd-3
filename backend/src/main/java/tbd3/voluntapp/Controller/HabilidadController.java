package tbd3.voluntapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbd3.voluntapp.Utils.AuthJWT;
import tbd3.voluntapp.entities.Habilidad;

import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.repositories.HabilidadRepository;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;
import tbd3.voluntapp.repositories.VoluntarioRepository;
import tbd3.voluntapp.services.HabilidadService;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    HabilidadRepository habilidadRepository;
    @Autowired
    private HabilidadService habilidadService;

    @Autowired
    JWTMiddlewareRepositoryImpl JWTMiddleware;
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @GetMapping("")
    public ResponseEntity<List<Habilidad>> getHabilidades() {

        return ResponseEntity.ok(habilidadRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Habilidad> createHabilidad(@RequestBody Habilidad habilidad,@RequestHeader("Authorization") String authorization) {
        System.out.println(habilidad);
        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(habilidadService.addHabilidad(habilidad));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countHabilidades(@RequestHeader("Authorization") String authorization) {
        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(voluntarioRepository.countTotalAbilities());
    }


    @GetMapping("/init")
    public String init() {
        Habilidad habilidad1 = new Habilidad("habilidad1", "habilidad1");
        Habilidad habilidad2 = new Habilidad("habilidad2", "habilidad2");
        Habilidad habilidad3 = new Habilidad("habilidad3", "habilidad3");
        habilidadRepository.save(habilidad1);
        habilidadRepository.save(habilidad2);
        habilidadRepository.save(habilidad3);
        return "Habilidades de prueba creadas";
    }
}
