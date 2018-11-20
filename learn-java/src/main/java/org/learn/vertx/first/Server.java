package org.learn.vertx.first;

import io.vertx.core.Vertx;
import org.learn.vertx.first.lesson1.verticles.FirstVerticle;

public class Server {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new FirstVerticle(vertx));

    }
}
