package com.example.teste;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class TesteKafkaStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteKafkaStreamApplication.class, args);
    }

    @Bean
    public Function<KStream<String, Long>, KStream<String, Long>> process(){
        return kStream ->  kStream
                .filter((k, v) -> v % 2 == 0)
                .peek((k, v) -> System.out.println("Squaring Even : " + v))
                .mapValues(v -> v * v);
    }



}
