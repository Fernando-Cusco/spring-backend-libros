package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Usuario;

import java.util.List;

public interface IUsuarioDao {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public Usuario findByEmail(String email);

    public void save(Usuario usuario);

    public Usuario login(String email, String password);
}
