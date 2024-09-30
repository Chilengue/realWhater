// package mati.com.backend.service;

// import java.time.Instant;
// import java.time.ZoneId;
// import java.time.ZonedDateTime;

// import org.springframework.stereotype.Service;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.exceptions.JWTCreationException;
// import com.auth0.jwt.exceptions.JWTVerificationException;

// import mati.com.backend.security.UserDetailsImpl;

// @Service
// public class JwtTokenService {
    
//     private static final String SECRET_KEY = "4Z^XrroxR@dWxqf$mTTKwW$!@#qGr4P"; // Chave secreta utilizada para gerar e verificar o token 

//     private static final String ISSUER = "pizzurg-api"; // Emissor do token

//     public String generateToken(UserDetailsImpl user) {
//         try {
//             Algorithm algorithm=Algorithm.HMAC256(SECRET_KEY);
//             return JWT.create()
//                       .withIssuer(ISSUER) //emit token
//                       .withIssuedAt(creationDate()) // Define a data de emissão do token
//                     .withExpiresAt(expirationDate()) // Define a data de expiração do token
//                     .withSubject(user.getUsername()) // Define o assunto do token (neste caso, o nome de usuário)
//                     .sign(algorithm); // Assina o token usando o algoritmo especificado
//         } catch (JWTCreationException exception) {
//             throw new JWTCreationException("Erro ao gerar token", exception);
//         }
//     }

//     public String getSubjectFromToken(String token){
//         try  {
//             Algorithm  algorithm=Algorithm.HMAC256(SECRET_KEY);
//             return JWT.require(algorithm)
//                       .withIssuer(ISSUER) //define o emissor do token
//                       .build()
//                       .verify(token)
//                       .getSubject();
//         } catch (JWTCreationException exception) {
//             throw new JWTVerificationException("token invalido ou expirado", exception);
//         }
//     }

//     private Instant creationDate(){
//         return ZonedDateTime.now(ZoneId.of("Mozambique/Maputo")).toInstant();
//     }
//     private Instant experationDate(){
//         return ZonedDateTime.now(ZoneId.of("Mozambique/maputo")).plusHours(4).toInstant();
//     }
// }
