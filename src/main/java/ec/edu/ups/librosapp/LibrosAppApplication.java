package ec.edu.ups.librosapp;

import ec.edu.ups.librosapp.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibrosAppApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IImageService service;
    public static void main(String[] args) {
        SpringApplication.run(LibrosAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String encoder = passwordEncoder.encode("admin");
        System.out.println(encoder + " password codificada");
        System.out.println("------------------------");
        boolean decode = passwordEncoder.matches("admin", encoder);
        System.out.println(decode + " las password es");
        service.init();
    }
}
