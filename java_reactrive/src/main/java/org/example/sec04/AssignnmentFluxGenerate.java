package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class AssignnmentFluxGenerate {

    public static void main(String[] args) {

        Flux.<String>generate(synchronousSink ->{
                String countryName = Util.getFaker().country().name();
                    System.out.println(countryName);
                synchronousSink.next(countryName);
        })
               .takeUntil(o -> o.equalsIgnoreCase("Canada"))
                .subscribe(Util.subscriber());

    }
}
