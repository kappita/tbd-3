package tbd3.voluntapp.Utils;

import tbd3.voluntapp.entities.responses.JWT;
import tbd3.voluntapp.repositories.JWTMiddlewareRepositoryImpl;

public class AuthJWT {

    private final JWTMiddlewareRepositoryImpl jwtMiddleware;

    public AuthJWT(JWTMiddlewareRepositoryImpl jwtMiddleware) {
        this.jwtMiddleware = jwtMiddleware;
    }

    public JWT validateAdminHeader(String authorization){
        String[] parts = authorization.split(" ");
        if (parts.length != 2) {
            return null;
        }

        if (!jwtMiddleware.validateToken(parts[1])) {
            return null;
        }

        JWT user = jwtMiddleware.decodeJWT(parts[1]);
        if (user.getUsertype() == 1) {
            return user;
        };

        return null;
    }

    public JWT validateVoluntarioHeader(String authorization){
        String[] parts = authorization.split(" ");
        if (parts.length != 2) {
            return null;
        }
        System.out.println("validando voluntario");
        if (!jwtMiddleware.validateToken(parts[1])){
            System.out.println("Token invalido");
            return null;
        }

        JWT user = jwtMiddleware.decodeJWT(parts[1]);
        System.out.println(user.toString());
        if (user.getUsertype() == 2) {

            System.out.println("decodificado");
            return user;
        }
        return null;
    }
}
