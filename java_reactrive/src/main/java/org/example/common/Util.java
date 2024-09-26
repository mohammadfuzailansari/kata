package org.example.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {

    public static Faker getFaker() {
        return faker;
    }

    private static final Faker faker = Faker.instance();
    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static void sleep(int milliSeconds) {

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Mono publisher = Mono.just(1);

        publisher.subscribe(subscriber("sub1"));

        publisher.subscribe(subscriber("sub2"));

    }

}
