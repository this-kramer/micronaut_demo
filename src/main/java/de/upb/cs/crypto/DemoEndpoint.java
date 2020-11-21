package de.upb.cs.crypto;

import javax.inject.Singleton;

import io.grpc.stub.StreamObserver;


@Singleton
public class DemoEndpoint extends MicronautDemoServiceGrpc.MicronautDemoServiceImplBase {
    private final DemoService demoService;

    public DemoEndpoint(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public void send(MicronautDemoRequest request, StreamObserver<MicronautDemoReply> responseObserver) {
        final String message = demoService.sayHello(request.getName());
        MicronautDemoReply reply = MicronautDemoReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
