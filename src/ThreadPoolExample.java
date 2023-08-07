import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // 创建一个固定大小为 3 的线程池
        ExecutorService executor = new ThreadPoolExecutor(3,4,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        // 提交任务给线程池执行
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            Runnable runnable = () -> {
                System.out.println("Task " + taskId + " is being executed by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟任务执行耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " has completed.");
            };
            executor.execute(runnable);
        }

        // 关闭线程池
        executor.shutdown();
    }
}
