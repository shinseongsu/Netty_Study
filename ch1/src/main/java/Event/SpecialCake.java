package Event;

import io.netty.util.concurrent.Future;

public class SpecialCake {
    public static void main(String[] args) throws InterruptedException {
        Bakery bakery = new Bakery();

        // 케이크를 주문하고 주문서를 받는다.
        Future future = bakery.orderCake();

        // 다른 일을 한다.
        // ...
        doSomthing();
        // ...

        // 케이크가 완성되었는지 확인한다.
        if(future.isDone()) {
            System.out.println("케이크 완성");
    //        Cake cake = future.getCake();
        } else {
            while(future.isDone() != true) {
                doSomthing();
            }

            System.out.println("케이크 완성");
        }

    }

    private static void doSomthing() throws InterruptedException {
        Thread.sleep(100);
    }

}

class Bakery    {
    public Future orderCake() {
        return null;
    }
}

class Cake{

}