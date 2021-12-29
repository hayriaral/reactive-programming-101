package org.hayriaral.reactiveprogramming101;

import reactor.core.publisher.Mono;

/**
 * @author hayri
 */
public class Part02CreateMono {

    public static void main(String... args) {

        Part02CreateMono monoCreator = new Part02CreateMono();

        //monoCreator.emptyMono().log().subscribe();
        //monoCreator.noSignalMono().log().subscribe();
        //monoCreator.stringMono().log().subscribe();
        //monoCreator.errorMono().subscribe();
    }

    /**
     * @return empty mono
     */
    Mono<String> emptyMono() {

        return Mono.empty();
    }

    /**
     * @return mono that will never signal any data, error or completion signal
     */
    Mono<String> noSignalMono() {

        return Mono.never();
    }

    /**
     * @return mono that contain only one value
     */
    Mono<String> stringMono() {

        return Mono.just("Izmir");
    }

    /**
     * @throws IllegalArgumentException exception
     */
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }
}