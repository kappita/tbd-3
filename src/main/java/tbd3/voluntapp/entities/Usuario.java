package tbd3.voluntapp.entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Usuario {
    @BsonId
    private ObjectId id;
    private String email;
    private String password;

    public Usuario(String email, String password, String id) {
        this.email = email;
        this.password = password;
        this.id = id != null ? new ObjectId(id): null;
    }

    public String getId() {
        return this.id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + this.getId() +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
