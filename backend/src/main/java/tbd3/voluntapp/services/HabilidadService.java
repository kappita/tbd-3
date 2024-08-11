package tbd3.voluntapp.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd3.voluntapp.Utils.AuthJWT;
import tbd3.voluntapp.Utils.Encrypter;
import tbd3.voluntapp.entities.Habilidad;
import tbd3.voluntapp.entities.Voluntario;

import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.entities.responses.LoginResponse;
import tbd3.voluntapp.entities.responses.RegisterResponse;
import tbd3.voluntapp.repositories.HabilidadRepository;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;
import tbd3.voluntapp.repositories.VoluntarioRepository;

import java.util.*;
@Service
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;


    @Autowired
    private JWTMiddlewareRepositoryImpl JWTGenerator;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public Habilidad addHabilidad(Habilidad habilidad) {

        return habilidadRepository.save(habilidad);
    }

}
