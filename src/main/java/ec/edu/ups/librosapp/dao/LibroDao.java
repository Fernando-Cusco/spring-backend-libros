package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Autor;
import ec.edu.ups.librosapp.models.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LibroDao implements ILibroDao{
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IAutorDao autorDao;

    @Override
    public List<Libro> findAll() {
        Session session = em.unwrap(Session.class);
        Query<Libro> query = session.createQuery("from Libro ");
        List<Libro> libros = query.getResultList();
        libros.forEach(libro -> System.out.println(libro.getAutores()));
        return libros;
    }

    @Override
    public Libro findById(int id) {
        Session session = em.unwrap(Session.class);
        Libro libro = session.get(Libro.class, id);
        for(Autor autor: libro.getAutores()) {
            System.out.println(autor.toString());
        }
        return libro;
    }

    @Override
    public void save(Libro libro) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(libro);
    }
}

