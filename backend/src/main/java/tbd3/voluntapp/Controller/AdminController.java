package tbd3.voluntapp.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbd3.voluntapp.entities.Admin;
import tbd3.voluntapp.entities.Voluntario;
import tbd3.voluntapp.entities.forms.AddHabilidadesForm;
import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.LoginResponse;
import tbd3.voluntapp.entities.responses.RegisterResponse;
import tbd3.voluntapp.repositories.AdminRepository;
import tbd3.voluntapp.repositories.VoluntarioRepository;
import tbd3.voluntapp.services.AdminService;
import tbd3.voluntapp.services.VoluntarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> createAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.register(admin));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm form) {
        return ResponseEntity.ok(adminService.login(form));
    }

    @GetMapping("/init")
    public String init() {
        Admin admin1 = new Admin("admin1", "admin1");
        adminService.register(admin1);
        return "Admin de prueba creado creado";
    }


}
