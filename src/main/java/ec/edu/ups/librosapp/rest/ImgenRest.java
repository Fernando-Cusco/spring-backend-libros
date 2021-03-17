package ec.edu.ups.librosapp.rest;

import ec.edu.ups.librosapp.service.IImageService;
import ec.edu.ups.librosapp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api")
public class ImgenRest {

    @Autowired
    private IImageService service;

    @PostMapping("/imagen/upload")
    public ResponseEntity<Response> uploadImage(@RequestParam("file")MultipartFile file) {
        String mensaje = "";
        Response response;
        try {
            response = new Response();
            String nombre = service.save(file);
            mensaje = "Imagen guardada: "+file.getOriginalFilename();
            response.setMensaje(mensaje);
            response.setError("No");
            response.setEstado("ok");
            response.setCodigo(nombre);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response = new Response();
            mensaje = "Error al guardar la imagen "+file.getOriginalFilename();
            response.setMensaje(mensaje);
            response.setError(e.getMessage());
            response.setEstado("error");
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/imagen/get/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file =  service.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
