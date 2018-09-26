package org.learn.java;


import io.vertx.core.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Future<String> mainFuture = Future.future();
        Future<Void> prev_f = Future.future();
        prev_f.complete();

        for(int i = 0; i < 10; i++) {
            Future<Void> next_f = Future.future();
            System.out.println("-->"+ i);
            int finalI = i;
            prev_f.setHandler(prev_res ->{
                System.out.println("1st Handler. "+ finalI);
                if(prev_res.failed()){
                    mainFuture.fail(prev_res.cause());
                    return;
                }
            });
            if(i==5){
                next_f.fail(new Exception("What the fuck....!It is 5"));
                return;
            } else {
                next_f.complete();
            }
            prev_f = next_f;
        }

        prev_f.setHandler(last_res -> {
            if(last_res.failed()) {
                System.out.println("Last Handler");
            } else  {
                System.out.println("Last Handler got through.");

            }
        });
        mainFuture.setHandler(mainResponse -> {
            System.out.println("This MF will die");
        });
    }
}
