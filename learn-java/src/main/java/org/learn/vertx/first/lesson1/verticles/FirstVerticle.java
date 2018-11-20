package org.learn.vertx.first.lesson1.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public class FirstVerticle extends AbstractVerticle {

    private HttpServer httpServer = null;
    private Vertx vertx;
    private Router router = Router.router(vertx);



    public FirstVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {
        httpServer = vertx.createHttpServer();

        httpServer.requestHandler(router::accept).listen(10000);

        router.route("/test").handler( this::getResult);
    }


    private void getResult(RoutingContext context) {
        List<String> parmList = context.queryParam("t");
        System.out.println(parmList.size());
        parmList.forEach(value -> System.out.println(value));
        context.queryParam("Test");
        context.response().end();
    }

}
