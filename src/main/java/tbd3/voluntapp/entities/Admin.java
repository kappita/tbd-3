package tbd3.voluntapp.entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Admin extends Usuario {
    public Admin() {
        super(null, null, null);
    }
    public Admin(String email, String password) {
        super(email, password, null);
    }
}
