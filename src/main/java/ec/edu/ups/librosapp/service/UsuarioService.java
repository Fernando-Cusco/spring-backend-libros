package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.dao.IUsuarioDao;
import ec.edu.ups.librosapp.models.Rol;
import ec.edu.ups.librosapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioDao dao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        String encodePassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodePassword);
        dao.save(usuario);
    }

    @Override
    public Usuario login(String email, String password) {
        Usuario usuario = dao.findByEmail(email);
        if (usuario != null) {
            boolean correctPassword = passwordEncoder.matches(password, usuario.getPassword());
            return correctPassword ? usuario : null;
        }
        return null;

    }

}
