package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.dao.IRolDao;
import ec.edu.ups.librosapp.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService implements IRolService{

    @Autowired
    private IRolDao dao;

    public Rol findByName(String name) {
        return dao.findByName(name);
    }
}
