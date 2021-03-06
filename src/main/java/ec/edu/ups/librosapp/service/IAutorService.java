package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.models.Autor;

import java.util.List;

public interface IAutorService {
    public List<Autor> findAll();

    public Autor findById(int id);

    public void save(Autor autor);

    public void deleteById(int id);

}
