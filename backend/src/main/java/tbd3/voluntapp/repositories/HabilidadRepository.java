package tbd3.voluntapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tbd3.voluntapp.entities.Habilidad;

import java.util.Collection;
import java.util.List;

public interface HabilidadRepository extends MongoRepository<Habilidad, ObjectId> {

}
