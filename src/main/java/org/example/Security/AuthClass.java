package org.example.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@NoArgsConstructor
public class AuthClass{
    private final String SECRET_ACCESS ="rtdffhbdfhjdbfhsbfbsdfbsdbfhsjdbfjhsdb";
    private final String SECRET_REFRESH="aresadaxsdfaxsfdaxsfAXSFXAsdxasxafsa";
    public  String createRefresh(String login){
        return Jwts
                .builder()
                .setSubject(login)
                .signWith(Keys.hmacShaKeyFor(SECRET_REFRESH.getBytes()))
                .claim("ROLE","USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1296000000))
                .compact();
    }
    public String createToken(String login){
        return Jwts
                .builder()
                .setSubject(login)
                .signWith(Keys.hmacShaKeyFor(SECRET_ACCESS.getBytes()))
                .claim("ROLE","USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 900000))
                .compact();
    }
    public String getLoginAccess(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_ACCESS.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public String getLoginRefresh(String token){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_REFRESH.getBytes()))
                .build().parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public Boolean validetTokenRefresh(String tokenRefresh){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_REFRESH.getBytes()))
                    .build()
                    .parseClaimsJws(tokenRefresh);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
