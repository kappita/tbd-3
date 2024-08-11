package tbd3.voluntapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tbd3.voluntapp.entities.Admin;
import tbd3.voluntapp.entities.Voluntario;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByEmail(String email);
}
