package tutorial.mision.tic.universidad.seguridad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviciosprueba {

    @GetMapping("/saludo")
    public String hello() {
        return "HOLA MUNDO";
    }

}