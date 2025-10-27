import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockCounter {
    private int count = 0;

    // 1. 创建一个 ReentrantLock 实例
    private final Lock lock = new ReentrantLock();

    public void increment() {
        // 2. 手动获取锁
        lock.lock();
        try {
            // 3. 临界区（受保护的代码）
            count++;
        } finally {
            // 4. 必须在 finally 块中释放锁，确保锁一定会被释放
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCounter counter = new ReentrantLockCounter();

        // 线程1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        // 线程2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        // 等待 t1 和 t2 执行完毕
        t1.join();
        t2.join();

        System.out.println("ReentrantLock Counter 最终结果: " + counter.getCount());
    }
}