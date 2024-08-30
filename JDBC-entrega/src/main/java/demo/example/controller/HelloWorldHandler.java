package demo.example.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HelloWorldHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        byte[] helloWorldByte = "Hello World".getBytes();
        exchange.sendResponseHeaders(200, helloWorldByte.length);

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(helloWorldByte);

        outputStream.close();
        System.out.println("Executou novamente");

    }
}
