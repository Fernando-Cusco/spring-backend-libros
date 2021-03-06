package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.dao.ILibroDao;
import ec.edu.ups.librosapp.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private ILibroDao dao;

    @Override
    public List<Libro> findAll() {
        return dao.findAll();
    }

    @Override
    public Libro findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Libro libro) {
        dao.save(libro);
    }
}
