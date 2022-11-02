package tutorial.mision.tic.universidad.seguridad.controller;
import tutorial.mision.tic.universidad.seguridad.modelos.Usuario;
import tutorial.mision.tic.universidad.seguridad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository miRepositorioUsuario;
    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepositorioUsuario.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario){
        infoUsuario.setContrasena(convertirSHA256(infoUsuario.getContrasena()));
        return this.miRepositorioUsuario.save(infoUsuario);
    }
    @GetMapping("{id}")
    public Usuario show(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElse(null);
        return usuarioActual;
    }
    @PutMapping("/{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario) {
        Optional<Usuario> opt = this.miRepositorioUsuario.findById(id);
        if(opt.isPresent())
        {
            Usuario actual = opt.get();

            if(infoUsuario.getContrasena() != null && !infoUsuario.getContrasena().isBlank())
                actual.setContrasena(infoUsuario.getContrasena());
            if(infoUsuario.getSeudonimo() != null && !infoUsuario.getSeudonimo().isBlank())
                actual.setSeudonimo(infoUsuario.getSeudonimo());
            if(infoUsuario.getCorreo() != null && !infoUsuario.getCorreo().isBlank())
                actual.setCorreo(infoUsuario.getCorreo());

            return this.miRepositorioUsuario.save(actual);
        }
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElse(null);
        if (usuarioActual!=null){
            this.miRepositorioUsuario.delete(usuarioActual);
        }
    }
    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}