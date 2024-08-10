package tbd3.voluntapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tbd3.voluntapp.entities.Voluntario;

import java.util.Optional;

public interface VoluntarioRepository extends MongoRepository<Voluntario, ObjectId> {
    Optional<Voluntario> findByEmail(String email);
}
