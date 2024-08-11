package tbd3.voluntapp.services;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd3.voluntapp.Utils.AuthJWT;
import tbd3.voluntapp.Utils.Encrypter;
import tbd3.voluntapp.entities.Habilidad;
import tbd3.voluntapp.entities.Usuario;
import tbd3.voluntapp.entities.Voluntario;
import tbd3.voluntapp.entities.forms.AddHabilidadesForm;

import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.entities.responses.LoginResponse;
import tbd3.voluntapp.entities.responses.RegisterResponse;
import tbd3.voluntapp.repositories.HabilidadRepository;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;
import tbd3.voluntapp.repositories.VoluntarioRepository;

import java.util.*;


@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;


    @Autowired
    private JWTMiddlewareRepositoryImpl JWTGenerator;

    @Autowired
    private HabilidadRepository habilidadRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public Voluntario getVoluntario(String id) {
        ObjectId idObjeto = new ObjectId(id);
        Optional<Voluntario> voluntario = voluntarioRepository.findById(idObjeto);
        return voluntario.orElse(null);
    }

    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.findAll();
    }

    public Voluntario saveVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public Voluntario addHabilidades(AddHabilidadesForm form, JWT user) {

        Voluntario voluntario = getVoluntario(user.getId());
        List<String> idHabilidades = form.getHabilidades();

        List<Habilidad> currentHabilidades = voluntario.getHabilidades();

        List<String> currentIds = currentHabilidades.stream().map(Habilidad::getId).toList();

        idHabilidades.addAll(currentIds);
        Set<String> habilidadesSet = new HashSet<>(idHabilidades);

        List<ObjectId> ObjectIdHabilidades = new ArrayList<>();
        for (String id : habilidadesSet) {
            ObjectIdHabilidades.add(new ObjectId(id));
        }

        List<Habilidad> newHabilidades = habilidadRepository.findAllById(ObjectIdHabilidades);

        voluntario.setHabilidades(newHabilidades);
        return voluntarioRepository.save(voluntario);
    }

    public LoginResponse login(LoginForm form) {
        Optional<Voluntario> vol = voluntarioRepository.findByEmail(form.getEmail());
        if (vol.isEmpty()) {
            return new LoginResponse(false, null);
        }

        Voluntario voluntario = vol.get();
        System.out.println(form.getPassword());
        if (!form.getPassword().equals(Encrypter.decrypt(voluntario.getPassword(), voluntario.getEmail()))){
            return new LoginResponse(false, null);
        }

        String jwt = JWTGenerator.generateToken(new JWT(voluntario, 2));
        return new LoginResponse(true, jwt);
    }

    public RegisterResponse register(Voluntario vol) {
        Optional<Voluntario> previous = voluntarioRepository.findByEmail(vol.getEmail());
        if (previous.isPresent()) {
            return new RegisterResponse(false, "El correo ya fue utilizado");
        }
        vol.setPassword(Encrypter.encrypt(vol.getPassword(),vol.getEmail()));
        voluntarioRepository.save(vol);
        return new RegisterResponse(true, "Voluntario guardado correctamente");
    }


}
