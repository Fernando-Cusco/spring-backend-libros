package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public void save(Usuario usuario);

    public Usuario login(String email, String password);
}
