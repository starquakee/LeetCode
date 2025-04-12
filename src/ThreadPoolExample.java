import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("执行任务：" + taskId + "，线程：" + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // 关闭线程池（不再接收新任务）
    }
}
