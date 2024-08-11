package tbd3.voluntapp.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbd3.voluntapp.Utils.AuthJWT;
import tbd3.voluntapp.entities.Voluntario;
import tbd3.voluntapp.entities.forms.AddHabilidadesForm;

import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.entities.responses.LoginResponse;
import tbd3.voluntapp.entities.responses.RegisterResponse;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;
import tbd3.voluntapp.repositories.VoluntarioRepository;
import tbd3.voluntapp.services.VoluntarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Autowired
    private VoluntarioService voluntarioService;

    @Autowired
    JWTMiddlewareRepositoryImpl JWTMiddleware;

    @GetMapping("")
    public ResponseEntity<List<Voluntario>> listVoluntarios(@RequestHeader("Authorization") String authorization) {

        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(voluntarioRepository.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> createVoluntario(@RequestBody Voluntario voluntario) {
        return ResponseEntity.ok(voluntarioService.register(voluntario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm form) {
        return ResponseEntity.ok(voluntarioService.login(form));
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Optional<Voluntario>> getVoluntario(@PathVariable String id, @RequestHeader("Authorization") String authorization) {

        JWT validation = new AuthJWT(JWTMiddleware).validateAdminHeader(authorization);
        if (validation == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(voluntarioRepository.findById(new ObjectId(id)));
    }

    @PostMapping("/addHabilidades")
    public ResponseEntity<Voluntario> addHabilidades(@RequestBody AddHabilidadesForm form,@RequestHeader("Authorization") String authorization) {

        JWT user = new AuthJWT(JWTMiddleware).validateVoluntarioHeader(authorization);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(voluntarioService.addHabilidades(form,user));
    }
    @GetMapping("/init")
    public String init() {
        Voluntario voluntario1 = new Voluntario("hola", "hola", "hola", "hola");
        Voluntario voluntario2 = new Voluntario("adios", "adios", "adios", "adios");
        Voluntario voluntario3 = new Voluntario("ej1", "ej1", "ej1", "ej1");
        voluntarioService.register(voluntario1);
        voluntarioService.register(voluntario2);
        voluntarioService.register(voluntario3);
        return "Voluntarios de prueba creados";
    }
}

