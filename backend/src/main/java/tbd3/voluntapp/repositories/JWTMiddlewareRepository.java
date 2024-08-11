package tbd3.voluntapp.repositories;

import tbd3.voluntapp.entities.forms.LoginForm;
import tbd3.voluntapp.entities.responses.JWT;

public interface JWTMiddlewareRepository {
    public String generateToken(JWT form);
    public Boolean validateToken(String token);
    public JWT decodeJWT(String token);
}