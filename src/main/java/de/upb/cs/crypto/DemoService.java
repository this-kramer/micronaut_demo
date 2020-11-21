package de.upb.cs.crypto;

import javax.inject.Singleton;

@Singleton
public class DemoService {

    String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
