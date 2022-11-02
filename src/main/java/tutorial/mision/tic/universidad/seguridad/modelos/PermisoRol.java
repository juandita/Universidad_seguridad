package tutorial.mision.tic.universidad.seguridad.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PermisoRol {

    @Id
    private String _id;

}