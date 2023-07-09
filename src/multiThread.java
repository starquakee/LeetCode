import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class multiThread {
    private static final Lock lock = new ReentrantLock(); // 锁对象
    private static final Condition conditionA = lock.newCondition(); // 控制打印"A"的条件
    private static final Condition conditionB = lock.newCondition(); // 控制打印"B"的条件
    private static boolean isPrintingA = true; // 控制打印"A"和"B"的标志
    /**lock.lock();
    try {
        while(不满足条件){
            conditionA.await();
        }
        do things;
        改变条件；
        conditionB.signal();
    }finally {
        lock.unlock();
    }*/
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (!isPrintingA){
                        conditionA.await();
                    }
                    System.out.println("A");
                    isPrintingA = false;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (isPrintingA){
                        try {
                            conditionB.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("B");
                    isPrintingA = true;
                    conditionA.signal();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
