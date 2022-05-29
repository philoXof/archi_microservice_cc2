package com.example.archi_microservice_cc2;


import com.example.archi_microservice_cc2.domain.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    //Creating Connection with Redis
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    //Creating RedisTemplate for Entity 'Payment'
    @Bean
    public RedisTemplate<String, Payment> redisTemplate(){
        RedisTemplate<String, Payment> empTemplate = new RedisTemplate<>();
        empTemplate.setConnectionFactory(redisConnectionFactory());
        return empTemplate;
    }
}
