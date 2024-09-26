package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Operator {
    /*
    * Handle - filter and map
    *
    * */

    public static void main(String[] args) {
        handleUnitAssignment();

    }

    private static void handleUnitAssignment() {
        Flux.<String>generate(synchronousSink -> {
            synchronousSink.next(Util.getFaker().country().name());
                })
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.equalsIgnoreCase("canada"))
                        synchronousSink.complete();
                  })
                .subscribe(Util.subscriber());
    }
}
