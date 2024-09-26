package org.example.common;

import org.example.common.AbstractHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {


    public Flux<String> getProductNameStream(String uri){
        return this.httpClient.get()
                .uri(uri)
                .responseContent()
                .asString();

    }

    public Mono<String> getProductName(String uri){
        return this.httpClient.get()
                .uri(uri)
                .responseContent()
                .asString()
                .next();

    }

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();
    }

    public Mono<String> getProductName(String uri, int productId){
        return this.httpClient.get()
                .uri(uri+productId)
                .responseContent()
                .asString()
                .next();

    }

}
