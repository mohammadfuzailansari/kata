package org.example.sec03;

import org.example.common.AbstractHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    public Flux<String> getData(String uri){
        return this.httpClient.get()
                .uri(uri)
                .responseContent()
                .asString();


    }

}
