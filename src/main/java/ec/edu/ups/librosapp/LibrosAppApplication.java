package ec.edu.ups.librosapp;

import ec.edu.ups.librosapp.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosAppApplication implements CommandLineRunner {

    @Autowired
    private IImageService service;
    public static void main(String[] args) {
        SpringApplication.run(LibrosAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.init();
    }
}
