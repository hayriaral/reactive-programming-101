package org.hayriaral.reactiveprogramming101;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Part01CreateFluxTest {

    private Part01CreateFlux mockFluxCreator = new Part01CreateFlux();

    @Test
    void emptyFlux() {

        Flux<String> sequence = mockFluxCreator.emptyFlux();

        StepVerifier.create(sequence)
                .verifyComplete();
    }

    @Test
    void stringFluxFromValues() {

        Flux<String> sequence = mockFluxCreator.stringFluxFromValues();

        StepVerifier.create(sequence)
                .expectNext("A","B","ABC")
                .verifyComplete();
    }

    @Test
    void stringFluxFromList() {

        Flux<String> sequence = mockFluxCreator.stringFluxFromList();

        StepVerifier.create(sequence)
                .expectNext("A","B","C")
                .verifyComplete();
    }

    @Test
    void stringFluxFromArray() {

        Flux<String> sequence = mockFluxCreator.stringFluxFromArray();

        StepVerifier.create(sequence)
                .expectNext("X", "Y", "Z")
                .verifyComplete();
    }

    @Test
    void errorFlux() {

        Flux<String> sequence = mockFluxCreator.errorFlux();

        StepVerifier.create(sequence)
                .verifyError(IllegalArgumentException.class);
    }

    @Test
    void integerFluxFromRange() {

        Flux<Integer> sequence = mockFluxCreator.integerFluxFromRange();

        StepVerifier.create(sequence)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }

    @Test
    void counter() {

        Flux<Long> sequence = mockFluxCreator.counter();

        StepVerifier.create(sequence)
                .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .verifyComplete();
    }
}