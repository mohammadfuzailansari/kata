package org.example.sec06.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class RevenueSubscriber  implements Subscriber<Order> {

    public static final HashMap<String, Double> revenueMap = new HashMap<>();

    public static final Logger logger = LoggerFactory.getLogger(RevenueSubscriber.class);

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);

    }

    @Override
    public void onNext(Order order) {
        logger.info("Received Order {}",order);

        String category = order.getCatregory();
        double revenue = order.getPrice();

        if( revenueMap.containsKey(category)){

            double oldRevenuw = revenueMap.get(category);
            revenue += oldRevenuw;
            revenueMap.put(category,revenue);
        }else{
            revenueMap.put(category,revenue);
        }

        logger.info("New Revenue for category {} is {}",category,revenue);
    }

    private String getData(String s, int index) {

        String[] split = s.split(":");
        return  split[index];
    }


    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
