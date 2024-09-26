package org.example.sec05;

import org.example.common.ExternalServiceClient;
import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Assignment {


    public static void main(String[] args) {


        for (int i = 1; i < 5; i++) {

            getProductName(i).subscribe(Util.subscriber());


        }


        Util.sleep(10000);


    }

    private static Mono<String> getProductName(int i) {

        final String PRODUCT_URI = "/demo03/product/" + i;
        final String PRODUCT_FALLBACK_URI = "/demo03/empty-fallback/product/" + i;
        final String PRODUCT_TIMEOUT_URI = "/demo03/timeout-fallback/product/" + i;

        return new ExternalServiceClient().getProductName(PRODUCT_URI).timeout(Duration.ofSeconds(2), new ExternalServiceClient().getProductName(PRODUCT_TIMEOUT_URI)).switchIfEmpty(new ExternalServiceClient().getProductName(PRODUCT_FALLBACK_URI));


    }
}
