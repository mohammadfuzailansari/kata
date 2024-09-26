package org.example.sec01.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    public Logger logger = LoggerFactory.getLogger(SubscriptionImpl.class);

    private boolean isCancelled;
    private int MAX_COUNT = 10;

    private Faker faker;
    Subscriber subscriber;
    public SubscriptionImpl(Subscriber subscriber) {

        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }


    @java.lang.Override
    public void request(long requestedCount) {

        if(!isCancelled){
            if(requestedCount > MAX_COUNT){
                subscriber.onNext(new RuntimeException("MAX Limit ASked"));
                isCancelled = true;

            }
            for (int recordCount = 0; recordCount < requestedCount && recordCount <= MAX_COUNT; recordCount++) {
                this.subscriber.onNext(this.faker.internet().emailAddress());

                if(recordCount == MAX_COUNT){
                    logger.info("no more data to produce reached max limit");
                    this.subscriber.onComplete();
                    this.isCancelled = true;

                }



                
            }

        }

    }

    @java.lang.Override
    public void cancel() {
        System.out.println("Cancel requested");
        this.isCancelled = true;

    }
}
