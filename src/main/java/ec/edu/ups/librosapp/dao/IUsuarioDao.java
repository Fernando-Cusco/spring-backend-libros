package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Rol;
import ec.edu.ups.librosapp.models.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioDao {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public Usuario findByEmail(String email);

    public void save(Usuario usuario);

    public Usuario login(String email, String password);

}
