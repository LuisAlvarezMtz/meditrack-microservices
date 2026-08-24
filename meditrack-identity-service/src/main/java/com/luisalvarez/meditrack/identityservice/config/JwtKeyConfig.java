package com.luisalvarez.meditrack.identityservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class JwtKeyConfig {

    @Value("${jwt.private-key}")
    private String privateKeyContent;

    @Value("${jwt.public-key}")
    private String publicKeyContent;

    @Bean
    public PrivateKey privateKey() throws Exception {
        String cleaned = privateKeyContent.replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(cleaned);
        return KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
    }

    @Bean
    public PublicKey publicKey() throws Exception {
        String cleaned = publicKeyContent.replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(cleaned);
        return KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
    }

}
