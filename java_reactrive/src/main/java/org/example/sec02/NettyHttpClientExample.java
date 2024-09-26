package org.example.sec02;

import io.netty.handler.logging.LogLevel;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

public class NettyHttpClientExample {

    public static void main(String[] args) {
        HttpClient client = HttpClient.create()
                .wiretap("reactor.netty.http.client.HttpClient",
                        LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
                .baseUrl("http://localhost:7070")
                .followRedirect(true);

        Mono<String> responseMono = client.get()
                .uri("/demo01/product/1")
                .responseContent()
                .aggregate()
                .asString()
                .onErrorResume(e -> {
                    System.err.println("Request failed: " + e.getMessage());
                    return Mono.empty();
                });

        String response = responseMono.block();
        System.out.println("Response: " + response);


        /*responseMono.subscribe(response -> {
            System.out.println("Response received: ");
            System.out.println(response);
        });*/
    }
}
