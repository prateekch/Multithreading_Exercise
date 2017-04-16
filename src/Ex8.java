import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Ex8 {
        public static void main(String[] args) {
            PubSub1 pubSub=new PubSub1();

            Thread thread1=new Thread(()->pubSub.subscriber());
            Thread thread2=new Thread(()->pubSub.publisher());
            Thread thread3=new Thread(()->pubSub.subscriber());
            Thread thread4=new Thread(()->pubSub.publisher());

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    class PubSub1{
        private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        public void subscriber() {
            for (int i = 0; i < 2; i++) {
                String message = "";
                try {
                    message = queue.take();
                } catch (InterruptedException e) {
                }
                System.out.println( "Message subscribed by : "+Thread.currentThread().getName()+" = " + message);
            }
        }

        public void publisher() {
            for (int i = 0; i < 2; i++) {
                String message = "message"+i;
                try {
                    queue.put(message);
                } catch (InterruptedException e) {
                }
                System.out.println("Message published by : "+Thread.currentThread().getName()+" = " + message);
            }
        }

}
