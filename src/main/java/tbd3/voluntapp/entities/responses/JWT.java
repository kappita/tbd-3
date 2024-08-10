package tbd3.voluntapp.entities.responses;

import tbd3.voluntapp.entities.Admin;
import tbd3.voluntapp.entities.Usuario;
import tbd3.voluntapp.entities.Voluntario;

public class JWT extends Usuario {
    private Integer usertype;




    public JWT(Usuario usuario, Integer usertype) {
        super(usuario.getEmail(), usuario.getPassword(), usuario.getId());
        this.usertype = usertype;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "JWT{" +
                "usertype=" + usertype +
                '}' + super.toString();
    }
}
