package tutorial.mision.tic.universidad.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.mision.tic.universidad.seguridad.modelos.PermisoRol;

public interface PermisoRolRepository extends MongoRepository<PermisoRol, String> {
}