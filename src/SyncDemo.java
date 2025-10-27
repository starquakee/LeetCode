class SynchronizedCounter {
    private int count = 0;

    // 使用 synchronized 关键字修饰方法
    // 任何线程在调用此方法前，都必须获取 SynchronizedCounter 实例的锁
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

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

        System.out.println("Synchronized Counter 最终结果: " + counter.getCount());
    }
}