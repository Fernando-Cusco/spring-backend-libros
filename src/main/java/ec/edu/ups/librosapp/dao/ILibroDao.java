package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Libro;

import java.util.List;

public interface ILibroDao {

    public List<Libro> findAll();

    public Libro findById(int id);

    public void save(Libro libro);
}
