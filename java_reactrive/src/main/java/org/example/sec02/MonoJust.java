package org.example.sec02;

import org.example.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {
        Publisher publisher  = Mono.just("Fuzail");
        SubscriberImpl subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);

    }
}
