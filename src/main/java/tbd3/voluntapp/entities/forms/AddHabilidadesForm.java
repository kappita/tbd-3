package tbd3.voluntapp.entities.forms;

import tbd3.voluntapp.entities.Habilidad;

import java.util.List;


public class AddHabilidadesForm {
    private String token;
    private List<String> habilidades;

    public AddHabilidadesForm(String token, List<String> habilidades) {
        this.token = token;
        this.habilidades = habilidades;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
