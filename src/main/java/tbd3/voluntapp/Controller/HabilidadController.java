package tbd3.voluntapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbd3.voluntapp.Utils.AuthJWT;
import tbd3.voluntapp.entities.Habilidad;

import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.repositories.HabilidadRepository;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;
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

    @GetMapping("")
    public ResponseEntity<List<Habilidad>> getHabilidades(@RequestHeader("Authorization") String authorization) {

        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(habilidadRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Habilidad> createHabilidad(@RequestBody Habilidad habilidad,@RequestHeader("Authorization") String authorization) {

        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(habilidadService.addHabilidad(habilidad));
    }
}
