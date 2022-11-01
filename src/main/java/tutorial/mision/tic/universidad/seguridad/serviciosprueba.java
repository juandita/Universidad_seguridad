package tutorial.mision.tic.universidad.seguridad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviciosprueba {

    @GetMapping("/saludos1")
    public String hello() {
        return "HOLA JEJEJE";
    }

}