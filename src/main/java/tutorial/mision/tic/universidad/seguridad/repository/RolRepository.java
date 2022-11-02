package tutorial.mision.tic.universidad.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.mision.tic.universidad.seguridad.modelos.Rol;

public interface RolRepository extends MongoRepository<Rol, String> {
}