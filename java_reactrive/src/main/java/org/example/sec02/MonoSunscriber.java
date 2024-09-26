package org.example.sec02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoSunscriber {

    static Logger log = LoggerFactory.getLogger(MonoSunscriber.class);

    public static void main(String[] args) {
        Mono publiser = Mono.just(1)
                .map(i -> i +2);

        publiser.subscribe(
                i -> log.info("Value is {}", i),
                error -> log.error("error {}",error.toString()),
                () -> log.info("Completed"),
                subscription -> ((Subscription) subscription).request(1)


        );

    }
}
