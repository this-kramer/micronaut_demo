package de.upb.cs.crypto;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;

@Factory
class Clients {
    @Bean
    MicronautDemoServiceGrpc.MicronautDemoServiceBlockingStub blockingStub(
            @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return MicronautDemoServiceGrpc.newBlockingStub(
                channel
        );
    }
}