package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Autor;
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
public class AutorDao implements IAutorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Autor> findAll() {
        Session session =  em.unwrap(Session.class);
        Query<Autor> query = session.createQuery("from Autor", Autor.class);
        List<Autor> autores = query.getResultList();
        return autores;
    }

    @Override
    public Autor findById(int id) {
        Session session = em.unwrap(Session.class);
        Autor autor =  session.get(Autor.class, id);
        return autor;
    }

    @Override
    public void save(Autor autor) {
        em.persist(autor);
    }

    @Override
    public void deleteById(int id) {
        Session session = em.unwrap(Session.class);
        Query<Autor> query =  session.createQuery("delete from Autor where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
