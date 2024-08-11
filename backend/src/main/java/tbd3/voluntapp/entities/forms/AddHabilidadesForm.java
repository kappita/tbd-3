package tbd3.voluntapp.entities.forms;

import tbd3.voluntapp.entities.Habilidad;

import java.util.List;


public class AddHabilidadesForm {
    private List<String> habilidades;

    public AddHabilidadesForm(){}
    public AddHabilidadesForm(List<String> habilidades) {

        this.habilidades = habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
