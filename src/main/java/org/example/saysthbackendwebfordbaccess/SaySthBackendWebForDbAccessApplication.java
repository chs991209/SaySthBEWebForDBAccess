package org.example.saysthbackendwebfordbaccess;

import org.example.saysthbackendwebfordbaccess.security.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(JwtProperties.class)
@SpringBootApplication
public class SaySthBackendWebForDbAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaySthBackendWebForDbAccessApplication.class, args);
    }


}
