package tbd3.voluntapp.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tbd3.voluntapp.entities.Usuario;
import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;

public class AuthJWT {

    private final JWTMiddlewareRepositoryImpl jwtMiddleware;

    public AuthJWT(JWTMiddlewareRepositoryImpl jwtMiddleware) {
        this.jwtMiddleware = jwtMiddleware;
    }

    public JWT validateAdmin(String token) {
        if (!jwtMiddleware.validateToken(token)) {
            return null;
        }


        JWT user = jwtMiddleware.decodeJWT(token);
        if (user.getUsertype() == 1) {
            return user;
        };
        return null;
    }

    public JWT validateVoluntario(String token) {
        System.out.println("validando voluntario");
        if (!jwtMiddleware.validateToken(token)){
            System.out.println("Token invalido");
            return null;
        }


        JWT user = jwtMiddleware.decodeJWT(token);
        System.out.println(user.toString());
        if (user.getUsertype() == 2) {

            System.out.println("decodificado");
            return user;
        }
        return null;
    }
}
