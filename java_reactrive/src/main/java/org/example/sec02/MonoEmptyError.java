package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyError {

    public static void main(String[] args) {
        //getUserDetails(3).subscribe(Util.subscriber());
        getUserDetails(3).subscribe(

                s -> System.out.println(s),
                e -> System.out.println(e.getMessage())

        );
    }

    private static Mono<String> getUserDetails(int id) {

        return switch(id){
            case 1 -> Mono.just("Fuzail");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Choise"));
        };

    }
}
