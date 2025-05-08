import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("执行任务：" + taskId + "，线程：" + Thread.currentThread().getName());
            });
        }
        executor.shutdown(); // 关闭线程池（不再接收新任务）


        ExecutorService executor1 = Executors.newFixedThreadPool(3);
        Future<?> f1 = executor1.submit(() -> System.out.println("任务1"));
        Future<?> f2 = executor1.submit(() -> System.out.println("任务2"));
        Future<?> f3 = executor1.submit(() -> System.out.println("任务3"));
        f1.get();  // 阻塞直到任务1完成
        f2.get();  // ...
        f3.get();
        executor1.shutdown();


        ExecutorService executor2 = Executors.newFixedThreadPool(3);
        // 构造任务
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.sleep(1000);
            return "任务1完成";
        });
        tasks.add(() -> {
            Thread.sleep(1500);
            return "任务2完成";
        });
        tasks.add(() -> {
            Thread.sleep(500);
            return "任务3完成";
        });

        // 提交并等待所有任务执行完毕
        List<Future<String>> results = executor2.invokeAll(tasks);
        executor2.shutdown();


        ExecutorService pool = new ThreadPoolExecutor(
                2,               // corePoolSize
                5,               // maximumPoolSize
                60,              // keepAliveTime
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), // 阻塞队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.execute(() -> {
                System.out.println("执行任务：" + taskId + "，线程：" + Thread.currentThread().getName());
            });
        }
        pool.shutdown();
    }
}
