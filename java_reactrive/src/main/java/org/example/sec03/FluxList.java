package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FluxList {

    public static void main(String[] args) {

//        System.out.println(getNamesList(10));

        getNamesFlux(10)
                .subscribe(Util.subscriber());

    }

    private static Flux<String> getNamesFlux(int count) {

        return Flux.range(1, count)
                .map(integer -> generateName());

    }

    private static List<String> getNamesList(int count) {
        List nameList = new ArrayList<String>();
        return IntStream.rangeClosed(1,count)
                .mapToObj(value -> generateName())
                .toList();
    }

    private static String generateName() {
        Util.sleep(1000);
        return Util.getFaker().name().fullName();
    }
}
