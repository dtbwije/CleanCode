package org.learn.java.codetests;

public class IfTest {


    private static boolean testBoolean = true;
    public static void main(String... args){

        IIfTest test = (b) -> {
            if(testBoolean){
                System.out.println(testBoolean);
                return;
            }
            System.out.println(testBoolean);
        };
        test.testMethod(true);
    }


}
