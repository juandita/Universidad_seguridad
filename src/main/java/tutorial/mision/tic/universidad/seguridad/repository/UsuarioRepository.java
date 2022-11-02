package tutorial.mision.tic.universidad.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.mision.tic.universidad.seguridad.modelos.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
