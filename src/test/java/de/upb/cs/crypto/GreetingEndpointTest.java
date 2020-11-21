package de.upb.cs.crypto;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import io.micronaut.test.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.*;


@MicronautTest
public class GreetingEndpointTest {

    @Inject
    MicronautDemoServiceGrpc.MicronautDemoServiceBlockingStub blockingStub;

    @Test
    void testHelloWorld() {
        final MicronautDemoRequest request = MicronautDemoRequest.newBuilder()
                .setName("Fred")
                .build();
        assertEquals(
                "Hello, Fred!",
                blockingStub.send(request)
                        .getMessage()
        );
    }

}