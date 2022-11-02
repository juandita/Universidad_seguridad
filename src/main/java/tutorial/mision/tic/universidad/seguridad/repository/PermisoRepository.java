package tutorial.mision.tic.universidad.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.mision.tic.universidad.seguridad.modelos.Permiso;

public interface PermisoRepository extends MongoRepository<Permiso, String> {
}