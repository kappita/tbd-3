package tbd3.voluntapp.repositories;

import tbd3.voluntapp.entities.Admin;
import tbd3.voluntapp.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.jsonwebtoken.*;
import tbd3.voluntapp.entities.responses.JWT;

import java.util.Date;
import javax.crypto.SecretKey;

@Repository
public class JWTMiddlewareRepositoryImpl implements JWTMiddlewareRepository {
    private final SecretKey secretKey;

    @Autowired
    public JWTMiddlewareRepositoryImpl(SecretKey secretKey){
        this.secretKey = secretKey;
    }

    @Override
    public String generateToken(JWT form){
        Date expiration_date = new Date(System.currentTimeMillis() + 14400000);

        return Jwts
                .builder()
                .claim("email", form.getEmail())
                .claim("password", form.getPassword())
                .claim("usertype", form.getUsertype())
                .claim("id", form.getId())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration_date)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Boolean validateToken(String token){
        try{
            Jws<Claims> jws = Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public JWT decodeJWT(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String email = claims.get("email", String.class);
        String password = claims.get("password", String.class);
        Integer type = claims.get("usertype", Integer.class);
        String id = claims.get("id", String.class);
        return new JWT(new Usuario(email, password, id), type);


    }
}