package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Rol;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RolDao implements IRolDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Rol findByName(String name) {
        Session session = em.unwrap(Session.class);
        try {
            Query<Rol> query = session.createQuery("from Rol where authority like :authority", Rol.class);
            query.setParameter("authority", name);
            Rol rol = query.getSingleResult();
            return rol;
        } catch (NoResultException e) {

        }
        return null;
    }
}
