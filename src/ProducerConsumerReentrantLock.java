import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReentrantLock {

    public static void main(String[] args) {

        // 1. 创建共享资源和锁
        final Queue<Integer> queue = new ArrayDeque<>();
        final int capacity = 10;

        // 创建一个可重入锁
        final ReentrantLock lock = new ReentrantLock();

        // 2. 从锁创建两个 "条件"
        // notFull 条件（用于生产者等待）
        final Condition notFull = lock.newCondition();
        // notEmpty 条件（用于消费者等待）
        final Condition notEmpty = lock.newCondition();

        // --- 生产者任务 ---
        Runnable producer = () -> {
            int i = 0;
            while (true) {
                // 3. 获取锁
                lock.lock();
                try {
                    // 4. 必须使用 while 循环检查条件
                    while (queue.size() == capacity) {
                        System.out.println(Thread.currentThread().getName() +
                                " [等待] 缓冲区已满...");
                        // 缓冲区已满，生产者在 "notFull" 条件上等待
                        // (await() 会自动释放锁)
                        notFull.await();
                    }

                    // 5. 生产
                    queue.add(i);
                    System.out.println("produce:" + i);
                    i++;

                    // 6. [精确唤醒] 唤醒所有正在 "notEmpty" 上等待的消费者
                    notEmpty.signalAll();

                } catch (InterruptedException e) {
                    // 恢复中断状态
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    // 7. 必须在 finally 块中释放锁
                    lock.unlock();
                }

                // Sleep 放在锁外面，避免长时间占用锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // --- 消费者任务 ---
        Runnable consumer = () -> {
            while (true) {
                // 3. 获取锁
                lock.lock();
                try {
                    // 4. 必须使用 while 循环检查条件
                    while (queue.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() +
                                " [等待] 缓冲区为空...");
                        // 缓冲区为空，消费者在 "notEmpty" 条件上等待
                        // (await() 会自动释放锁)
                        notEmpty.await();
                    }

                    // 5. 消费
                    Integer num = queue.poll();
                    System.out.println("consume:" + num);

                    // 6. [精确唤醒] 唤醒所有正在 "notFull" 上等待的生产者
                    notFull.signalAll();

                } catch (InterruptedException e) {
                    // 恢复中断状态
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    // 7. 必须在 finally 块中释放锁
                    lock.unlock();
                }

                // Sleep 放在锁外面
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // 启动线程
        new Thread(producer, "生产者-1").start();
        new Thread(consumer, "消费者-1").start();
        new Thread(consumer, "消费者-2").start();
    }
}