package org.example.sec01.subscriber;

import org.example.sec01.publisher.SubscriptionImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecordingLogger;

public class SubscriberImpl implements Subscriber<String> {

    public Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

    public Subscription getSubscription() {
        return subscription;
    }

    private Subscription subscription;
    @java.lang.Override
    public void onSubscribe(Subscription subscription) {

        this.subscription  =  subscription;

    }

    @java.lang.Override
    public void onNext(String s) {
        System.out.println("OnNext: "+ s);

    }

    @java.lang.Override
    public void onError(java.lang.Throwable throwable) {
        System.out.println("Error"+throwable.getMessage());

    }

    @java.lang.Override
    public void onComplete() {
        System.out.println("complete");
    }
}
