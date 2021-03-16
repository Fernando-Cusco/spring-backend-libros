package ec.edu.ups.librosapp.dao;

import ec.edu.ups.librosapp.models.Rol;

public interface IRolDao {

    public Rol findByName(String name);
}
