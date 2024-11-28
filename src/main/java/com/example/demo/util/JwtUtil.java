package com.example.demo.util;

import com.example.demo.dto.MemberDto;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET_KEY = "aGVhdnlmbG9vZCoqMDExOGdoZHRuISEqKmhlYXZ5Zmxvb2QuanI=";

    public static String generateToken(MemberDto member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getName());
        claims.put("role", "User");
        claims.put("exp", new Date(System.currentTimeMillis() + 86400000));
        claims.put("iat", new Date());

        return Jwts.builder()
                .setSubject(member.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .compact();
    }

    public static String validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static String getExpireDate(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
               .toString();
    }
}
