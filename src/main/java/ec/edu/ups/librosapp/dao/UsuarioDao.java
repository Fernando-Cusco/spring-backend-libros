package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Rol;
import ec.edu.ups.librosapp.models.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDao implements IUsuarioDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Usuario> findAll() {
        Session session = em.unwrap(Session.class);
        Query<Usuario> query = session.createQuery("from Usuario", Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    @Override
    public Usuario findById(int id) {
        Session session = em.unwrap(Session.class);
        Usuario usuario = session.get(Usuario.class, id);
        return usuario;
    }

    @Override
    public Usuario findByEmail(String email) {
        Session session = em.unwrap(Session.class);
        try {
            Query<Usuario> query = session.createQuery("from Usuario where email like :email", Usuario.class);
            query.setParameter("email", email);
            Usuario usuario = query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {

        }
        return null;
    }

    @Override
    public void save(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public Usuario login(String email, String password) {
        Session session = em.unwrap(Session.class);
        Query<Usuario> query = session.createQuery("from Usuario where email like :email and password like :password", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        Usuario usuario = query.getSingleResult();
        return usuario;
    }

}
