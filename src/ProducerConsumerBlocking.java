import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlocking {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);

        Runnable producer =()->{
            for(int i=0;i<1000000;i++){
                try {
                    sharedQueue.put(i);
                    System.out.println("produce:"+i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable consumer =()->{
            while (true){
                try {
                    Integer num = sharedQueue.take();
                    System.out.println("consume:"+num);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}