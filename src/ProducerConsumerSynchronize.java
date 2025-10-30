import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerSynchronize {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        int capacity=10;
        Runnable producer = ()->{
            int i=0;
            while (true){
                synchronized (queue){
                    while (queue.size()==capacity){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    queue.add(i);
                    System.out.println("produce:"+i);
                    i++;
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = ()->{
            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Integer num = queue.poll();
                    System.out.println("consume:"+num);
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}