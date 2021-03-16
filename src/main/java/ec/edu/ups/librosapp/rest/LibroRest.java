package ec.edu.ups.librosapp.rest;

import ec.edu.ups.librosapp.models.Libro;
import ec.edu.ups.librosapp.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api")
public class LibroRest {

    @Autowired
    private LibroService service;

    @GetMapping(value = "/libro/all")
    public ResponseEntity<List<Libro>> libros() {
        List<Libro> libros = service.findAll();
        if (libros.size() > 0) {
            return ResponseEntity.ok(libros);
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/libro/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable int id) {
        Libro libro = service.findById(id);
        if ( libro != null ) {
            return ResponseEntity.ok(libro);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/libro")
    public ResponseEntity<Libro> nuevo(@RequestBody Libro libro) {
        service.save(libro);
        return ResponseEntity.ok(libro);
    }


}
