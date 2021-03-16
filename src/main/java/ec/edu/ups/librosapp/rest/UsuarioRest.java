package ec.edu.ups.librosapp.rest;

import ec.edu.ups.librosapp.models.Usuario;
import ec.edu.ups.librosapp.service.IUsuarioService;
import ec.edu.ups.librosapp.utils.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api")
public class UsuarioRest {

    @Autowired
    private IUsuarioService service;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> nuevo(@RequestBody Usuario usuario) {
        service.save(usuario);
        usuario.setPassword("");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<Usuario> login(@RequestBody Credenciales credenciales) {
        Usuario empty = new Usuario();
        if (!credenciales.getEmail().isEmpty() && !credenciales.getPassword().isEmpty()) {
            Usuario usuario = service.login(credenciales.getEmail(), credenciales.getPassword());
            if (usuario != null) {
                usuario.setPassword("");
                usuario.setCorrectLogin(true);
                return ResponseEntity.ok(usuario);
            } else {
                empty.setCorrectLogin(false);
                return ResponseEntity.ok(empty);
            }
        }
        empty.setCorrectLogin(false);
        return ResponseEntity.ok(empty);
    }

}
