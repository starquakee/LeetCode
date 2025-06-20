public class CounterUnsafe {

    private int count = 0;

    public void increment() {
        count++; // 非原子操作
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        CounterUnsafe counter = new CounterUnsafe();
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

        System.out.println("使用普通int的最终结果: " + counter.getCount());
    }
}