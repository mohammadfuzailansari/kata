package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String countryName;
            do{
                countryName = Util.getFaker().country().name();
                fluxSink.next(countryName);
            }
            while(!countryName.equalsIgnoreCase("Canada"));
            fluxSink.complete();
        })
                .subscribe((Util.subscriber()));
    }
}
