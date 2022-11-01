package modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class usuario {
    @Id
    private String _id;
    private String seudonimo;
    private String correo;
    private String contrasena;

}