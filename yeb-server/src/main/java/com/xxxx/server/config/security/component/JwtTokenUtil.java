package com.xxxx.server.config.security.component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private static final String CLATM_KEY_USERNAME="sub";
    private static final String CLATM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    
    /*根据用户信息生成token*/
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLATM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLATM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /*从token中获取登录用户名*/
    public String getUserNameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /*验证token是否有效*/
    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /*判断token是否可以被刷新*/
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /*刷新token*/
    public String refreshToken(String token){
        Claims claims = getClaimsFormToken(token);
        claims.put(CLATM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /*判断token是否失效*/
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /*从token中获取过期时间*/
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }


    /*从token中获取荷载*/
    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /*根据荷载生成JWT token*/
    private String generateToken(Map<String,Object> calims) {
        return Jwts.builder()
                .setClaims(calims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /*生成token失效时间*/
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


}
