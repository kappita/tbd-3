package tbd3.voluntapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd3.voluntapp.Utils.Encrypter;
import tbd3.voluntapp.entities.Admin;
import tbd3.voluntapp.entities.Voluntario;
import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.entities.responses.LoginResponse;
import tbd3.voluntapp.entities.responses.RegisterResponse;
import tbd3.voluntapp.repositories.AdminRepository;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    private JWTMiddlewareRepositoryImpl JWTGenerator;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public LoginResponse login(LoginForm form) {
        Optional<Admin> adm = adminRepository.findByEmail(form.getEmail());
        if (adm.isEmpty()) {
            return new LoginResponse(false, null);
        }

        Admin admin = adm.get();

        if (!form.getPassword().equals(Encrypter.decrypt(admin.getPassword(), admin.getEmail()))){
            return new LoginResponse(false, null);
        }

        String jwt = JWTGenerator.generateToken(new JWT(admin, 1));
        return new LoginResponse(true, jwt);
    }

    public RegisterResponse register(Admin admin) {
        Optional<Admin> previous = adminRepository.findByEmail(admin.getEmail());
        if (previous.isPresent()) {
            return new RegisterResponse(false, "El correo ya fue utilizado");
        }
        admin.setPassword(Encrypter.encrypt(admin.getPassword(), admin.getEmail()));
        adminRepository.save(admin);
        return new RegisterResponse(true, "Admin guardado correctamente");
    }

}
