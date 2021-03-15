package ec.edu.ups.librosapp.utils;

import java.io.Serializable;

public class Response implements Serializable {
    private String mensaje;

    private String estado;

    private String error;

    private String codigo;
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private static final long serialVersionUID = 1L;
}
