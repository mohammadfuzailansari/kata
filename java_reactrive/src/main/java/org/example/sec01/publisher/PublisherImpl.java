package org.example.sec01.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherImpl  implements Publisher {

    public Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

    @java.lang.Override
    public void subscribe(Subscriber subscriber) {
        Subscription subscription = new SubscriptionImpl(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
