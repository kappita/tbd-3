package tbd3.voluntapp.entities;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;


public class Voluntario extends Usuario {


    private String nombre;
    private String rut;
    private List<Habilidad> habilidades;
    private Float latitud;
    private Float longitud;

    public Voluntario() {
        super(null, null, null);
        this.habilidades = new ArrayList<>();
        this.latitud = 0f;
        this.longitud = 0F;
    }

    public Voluntario(String email, String password, String nombre, String rut, Float latitud, Float longitud) {
        super(email, password, null);
        this.nombre = nombre;
        this.rut = rut;
        this.habilidades = new ArrayList<>();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", habilidades=" + habilidades +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
