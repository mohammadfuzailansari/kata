package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Quic {

    public static void main(String[] args) {

        /*Flux.range(1, 100)
                .take(25)
                //.takeWhile(i -> i < 10)
                .takeUntil(i -> i > 1 && i < 5)
                .take(3)
                .subscribe(Util.subscriber());*/

        Flux.range(1, 4)
                .map(i -> i / (2 - i))
                .onErrorReturn(3)
                .subscribe(Util.subscriber());
    }
}
