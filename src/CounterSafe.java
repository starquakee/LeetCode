import java.util.concurrent.atomic.AtomicInteger;

public class CounterSafe {

    // 1. 使用AtomicInteger并初始化为0
    private AtomicInteger atomicCount = new AtomicInteger(0);

    public void increment() {
        // 2. 使用原子方法进行自增
        atomicCount.incrementAndGet();
    }

    public int getCount() {
        // 3. 使用get()方法获取当前值
        return atomicCount.get();
    }

    public static void main(String[] args) throws InterruptedException {
        CounterSafe counter = new CounterSafe();
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        // 创建并启动10个线程
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("使用AtomicInteger的最终结果: " + counter.getCount());
    }
}