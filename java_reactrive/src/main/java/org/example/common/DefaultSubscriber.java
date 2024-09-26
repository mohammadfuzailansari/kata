package org.example.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private Logger logger = LoggerFactory.getLogger(DefaultSubscriber.class);

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    private String name;

    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        logger.info("{} OnNext: {} ", this.name, item);

    }

    @Override
    public void onError(Throwable throwable) {
        logger.error(" {} Error {}", this.name, throwable.getMessage());

    }

    @Override
    public void onComplete() {
        logger.info(" {} complete", this.name);
    }
}
