package com.vds.starter;

import com.vds.starter.port.CustomRestClient;
import org.springframework.web.client.RestClient;

public class App {
    public static void main(String[] args) {
        RestClient.create()
                .get()
                .uri("https://petclinic.example.com/pets/{id}", 2)

        Object body = CustomRestClient.create()
                .get()
                .url("https://api.thecatapi.com/v1/images/search")
                .retrieve()
                .body(Object.class);

        System.out.println(body);
    }
}
