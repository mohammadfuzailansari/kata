package org.example.sec01.demo;

import org.example.sec01.publisher.PublisherImpl;
import org.example.sec01.publisher.SubscriptionImpl;
import org.example.sec01.subscriber.SubscriberImpl;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        demo2();
    }

    private static void demo1(){

        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);

    }

    private static void demo2() throws InterruptedException {

        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);

        subscriber.getSubscription().request(3);
        Thread.sleep(2000);

        subscriber.getSubscription().request(30);
        Thread.sleep(2000);

        subscriber.getSubscription().request(3);
        Thread.sleep(2000);




    }


}

