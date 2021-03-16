package ec.edu.ups.librosapp.service;

import ec.edu.ups.librosapp.models.Rol;

public interface IRolService {
    public Rol findByName(String name);
}
