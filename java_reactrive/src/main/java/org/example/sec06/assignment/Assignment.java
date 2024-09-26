package org.example.sec06.assignment;

import org.example.common.ExternalServiceClient;
import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.emitter.Emitter;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Assignment {

    static Logger logger = LoggerFactory.getLogger(Assignment.class);

    public static void main(String[] args) {

        Flux<Order> order_stream = new ExternalServiceClient().getProductNameStream("/demo04/orders/stream")
                .map(s -> convertToOrder(s))
                .publish().refCount(1);

//        order_stream.subscribe(new RevenueSubscriber());


        EmitterProcessor<Order> orderProcessor = EmitterProcessor.create();
        FluxSink<Order> orderSink = orderProcessor.sink();


        EmitterProcessor<Order> revenueProcessor = EmitterProcessor.create();
        FluxSink<Order> revenueSink = revenueProcessor.sink();


        order_stream
                .doOnNext(orderSink::next)
                .subscribe();

        order_stream
                .doOnNext(revenueSink::next)
                .subscribe();

        orderProcessor.subscribe(order -> logger.info("Order reeived from orderprocessor {}",order));

        revenueProcessor.subscribe(order -> logger.info("Order reeived from revenueprocessor {}",order));



        //order_stream.subscribe(Util.subscriber());

        Util.sleep(100000);
    }

    private static Order convertToOrder(String s) {
        Order order = new Order();
        String[] split = s.split(":");

        order.setItem(split[0]);
        order.setCatregory(split[1]);
        order.setPrice(Float.parseFloat(split[2]));
        order.setQuantity(Integer.parseInt(split[3]));

        return order;


    }
}
