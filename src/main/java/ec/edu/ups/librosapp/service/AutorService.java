package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.dao.IAutorDao;
import ec.edu.ups.librosapp.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private IAutorDao dao;



    @Override
    public List<Autor> findAll() {
        return dao.findAll();
    }

    @Override
    public Autor findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Autor autor) {
        dao.save(autor);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
