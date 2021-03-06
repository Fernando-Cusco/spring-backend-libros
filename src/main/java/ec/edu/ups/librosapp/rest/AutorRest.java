package ec.edu.ups.librosapp.rest;

import ec.edu.ups.librosapp.models.Autor;
import ec.edu.ups.librosapp.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api")
public class AutorRest {

    @Autowired
    private IAutorService service;

    @GetMapping(value = "/autor/all")
    public ResponseEntity<List<Autor>> autores() {
        List<Autor> autores = service.findAll();
        if (autores.size() > 0) {
            return ResponseEntity.ok(autores);
        }
        return ResponseEntity.ok().build();
//        throw new RuntimeException("No existen autores");
    }

    @GetMapping(value = "/autor/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable int id) {
        Autor autor = service.findById(id);
        if ( autor != null ) {
            return ResponseEntity.ok(autor);
        }
        return ResponseEntity.ok().build();
//        throw new RuntimeException("Autor no encontrado");
    }

    @PostMapping(value = "/autor")
    public ResponseEntity<Autor> nuevo(@RequestBody Autor autor) {
        service.save(autor);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping(value = "/autor/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.ok("Autor eliminado");
    }
}
