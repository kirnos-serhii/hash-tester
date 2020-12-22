package com.khpi.demo.configuration;

import com.khpi.demo.exception.HashAlgorithmTesterRuntimeException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.zip.CRC32;

@Configuration
public class DefaultView implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/dashboard");
    }

    @Bean
    public MessageDigest messageDigest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new HashAlgorithmTesterRuntimeException("Can not create SHA-512 MessageDigest instance.");
        }
    }

    @Bean
    public CRC32 crc32() {
        return new CRC32();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}