package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.models.Libro;

import java.util.List;

public interface ILibroService {

    public List<Libro> findAll();

    public Libro findById(int id);

    public void save(Libro libro);
}
