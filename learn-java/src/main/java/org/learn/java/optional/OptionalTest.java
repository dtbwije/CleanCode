package org.learn.java.optional;

import io.netty.handler.codec.http.FullHttpRequest;
import io.vertx.core.Future;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest {

    private final String BEARER = "bearer ";

    private String generateToken(String some) throws JwtException {
        if(some == null) throw new JwtException();
        else return "someString";
    }


    private Optional<String> generateTokenWithBearer( Future<String> f){
        String headerValue = null;
        try{
            headerValue=  "Bearer " + generateToken("mm");
            f.complete(headerValue);
        } catch (JwtException e) {
            f.fail(e);
        }
        return Optional.ofNullable(headerValue);
    }

    public Future<String> test(){
        Future<String> ddResponseFuture = Future.future();


        Optional headerWithToken = generateTokenWithBearer(ddResponseFuture);
        headerWithToken.ifPresent(arg -> callIfPresent((String)arg));
        return  ddResponseFuture;
    }

    private void callIfPresent(String arg){
        System.out.println(arg + "OK");
    }

    public static void main(String... args){
        OptionalTest test = new OptionalTest();
        Future<String>  testFuture= test.test();
        testFuture.setHandler(result -> {
            if(result.failed()){
                System.out.println("Failed");
            }
            System.out.println( "Result is "+ result.result());

        });



    }
}
