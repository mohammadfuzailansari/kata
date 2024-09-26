package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromSupplier {
    static Logger log = LoggerFactory.getLogger(MonoFromSupplier.class);

    public static void main(String[] args) {
        List list = List.of(1,2,3,4,5);

        Mono.fromSupplier(() -> sum(list));
                //.subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list) {
        log.info("Finding sum");
        Util.sleep(2000);
        log.info("Awake");
        return list.stream().mapToInt(a -> a).sum();
    }
}
