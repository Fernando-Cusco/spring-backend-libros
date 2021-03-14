package ec.edu.ups.librosapp.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImagenService implements IImageService{
    private  final Path root = Paths.get("uploads");
    @Override
    public void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al crear la carpeta");
        }
    }

    @Override
    public String save(MultipartFile file) {
        if (!file.isEmpty()) {
            Path rootRoot = root.resolve(file.getOriginalFilename()).toAbsolutePath();
            File f = rootRoot.toFile();
            if (f.exists() && f.canRead()) {
                f.delete();
            }
        }
        String uniqueName = UUID.randomUUID().toString() + "_"+file.getOriginalFilename();
        Path path = root.resolve(uniqueName);
        Path absolutePath = path.toAbsolutePath();
        try {
            Files.copy(file.getInputStream(), absolutePath);
            return uniqueName;
        } catch (IOException e) {

            throw new RuntimeException("Error al guardar la imagen");

        }

    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Error al cargar la imagen");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }
}
