package org.hayriaral.reactiveprogramming101;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

class Part02CreateMonoTest {

    private Part02CreateMono mockMonoCreator = new Part02CreateMono();

    @Test
    void emptyMono() {

        Mono<String> mono = mockMonoCreator.emptyMono();

        StepVerifier.create(mono)
                .verifyComplete();
    }

    @Test
    void noSignalMono() {

        Mono<String> mono = mockMonoCreator.noSignalMono();

        StepVerifier.create(mono)
                .expectSubscription()
                .expectTimeout(Duration.ofSeconds(1L))
                .verify();
    }

    @Test
    void stringMono() {

        Mono<String> mono = mockMonoCreator.stringMono();

        StepVerifier.create(mono)
                .expectNext("Izmir")
                .verifyComplete();
    }

    @Test
    void errorMono() {

        Mono<String> mono = mockMonoCreator.errorMono();

        StepVerifier.create(mono)
                .verifyError(IllegalStateException.class);
    }
}