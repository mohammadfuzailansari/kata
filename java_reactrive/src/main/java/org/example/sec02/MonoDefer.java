package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoDefer {
    static Logger log = LoggerFactory.getLogger(MonoDefer.class);

    public static void main(String[] args) {

        //createPublisher()
        Mono.defer(() -> createPublisher())
                .subscribe(integer -> log.info(" sum is {}",integer));
    }

    private static Mono<Integer> createPublisher() {
        log.info("Creating Publicher");
        List list = List.of(1,2,3,4,5);
        Util.sleep(2000);
        return Mono.fromSupplier(() -> sum(list));

    }

    private static int sum(List<Integer> list) {
        log.info("Finding sum of {}",list);

        Util.sleep(3000);
        return list.stream().mapToInt(a -> a).sum();
    }
}
