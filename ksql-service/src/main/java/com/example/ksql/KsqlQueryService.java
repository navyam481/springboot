package com.example.ksql;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KsqlQueryService {
    private final WebClient webClient;

    public KsqlQueryService() {
    	this.webClient = WebClient.builder()
    	        .baseUrl("http://ksqldb-server:8088") 
    	        .defaultHeader("Content-Type", "application/json")
    	        .build();
    }

    public String executeQuery(String query) {
        return webClient.post()
                .uri("/query")
                .bodyValue("{\"ksql\":\"" + query + "\", \"streamsProperties\":{}}")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

