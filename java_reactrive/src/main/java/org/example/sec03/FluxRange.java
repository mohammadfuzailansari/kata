package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {
        /*Flux.range(3,10)
                .subscribe(integer -> System.out.println(Util.getFaker().name().fullName()));*/

        Flux.range(1,10)
                .map(integer -> Util.getFaker().name().fullName())
                .log("map-logger")
                .subscribe(Util.subscriber());
    }
}
