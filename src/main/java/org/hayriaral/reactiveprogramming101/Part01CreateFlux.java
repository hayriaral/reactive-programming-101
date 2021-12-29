package org.hayriaral.reactiveprogramming101;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Learn how to create {@link Flux}.
 *
 * @author hayri
 */
public class Part01CreateFlux {

    public static void main(String... args) {

        // Nothing happens until you subscribe.
        // Uncomment a line which you want to run.

        // Tip: If you want some insight as to what is going on inside Flux or Mono, you can append .log() to the instances.

        Part01CreateFlux fluxCreator = new Part01CreateFlux();

//        fluxCreator.emptyFlux().subscribe(System.out::println);
//        fluxCreator.stringFluxFromValues().subscribe(s -> System.out.println(s));
//        fluxCreator.stringFluxFromList().subscribe(System.out::println);
//        fluxCreator.stringFluxFromArray().subscribe(System.out::println);
//        fluxCreator.integerFluxFromRange().subscribe(System.out::println);
//        fluxCreator.errorFlux().subscribe();
//        fluxCreator.counter().subscribe();
    }

    /**
     * Creates empty flux.
     *
     * @return empty flux
     */
    Flux<String> emptyFlux() {

        Flux<String> noData = Flux.empty();

        return noData;
    }

    /**
     * Creates sequence of String.
     * <p>
     * Creates a Flux that emits the provided elements.
     *
     * @return sequence of String
     */
    Flux<String> stringFluxFromValues() {

        Flux<String> sequence = Flux.just("A", "B", "ABC");

        return sequence;
    }

    /**
     * Creates sequence of String.
     * <p>
     * Creates a Flux from a collection.
     *
     * @return sequence of String
     */
    Flux<String> stringFluxFromList() {

        List<String> myList = Arrays.asList("A", "B", "C");
        Flux<String> sequence = Flux.fromIterable(myList);

        return sequence;
    }

    /**
     * Creates sequence of String.
     * <p>
     * Creates a Flux from an array.
     *
     * @return sequence of String
     */
    Flux<String> stringFluxFromArray() {

        String[] myArray = {"X", "Y", "Z"};
        Flux<String> sequence = Flux.fromArray(myArray);

        return sequence;
    }

    /**
     * Create a Flux that terminates with an error immediately after being subscribed to.
     *
     * @throws IllegalArgumentException when it called
     */
    Flux<String> errorFlux() {

        return Flux.error(IllegalArgumentException::new);
    }

    /**
     * Creates sequence of Integer.
     * <p>
     * Creates a Flux from given range.
     *
     * @return sequence of Integer
     */
    Flux<Integer> integerFluxFromRange() {

        Flux<Integer> intSequence = Flux.range(1, 5);

        return intSequence;
    }

    /**
     * Creates sequence of Long.
     * <p>
     * Create a that emits long values starting with 0 and incrementing at specified time intervals on the global timer.
     *
     * @return sequence of Long
     */
    Flux<Long> counter() {

        return Flux.interval(Duration.ofMillis(1000L)).take(10L);
    }
}
