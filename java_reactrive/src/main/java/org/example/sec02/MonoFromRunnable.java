package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static final Logger log = LoggerFactory.getLogger(MonoFromRunnable.class);

    public static void main(String[] args) {

        getProductName(2)
                .subscribe(Util.subscriber());

        System.out.println("Done");
    }

    private static Mono<String> getProductName(int productId) {

        Mono publisher = null;
        if(productId ==1)
            publisher = Mono.fromSupplier(() -> Util.getFaker().commerce().productName());
        else
            publisher = Mono.fromRunnable(() -> notifyBusiness(productId));

        return publisher;

    }

    private static void notifyBusiness(int productId) {
        Util.sleep(2000);
        log.info("notifying busienss to handle {}", productId);
    }
}
