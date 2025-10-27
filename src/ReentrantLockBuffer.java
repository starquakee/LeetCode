import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    // 1. 创建锁和两个条件
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();  // "未满"条件
    private final Condition notEmpty = lock.newCondition(); // "未空"条件

    public ReentrantLockBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            // 2. 检查队列是否已满
            while (queue.size() == capacity) {
                System.out.println("队列已满, 生产者 " + Thread.currentThread().getName() + " 等待中...");
                notFull.await(); // 在 "notFull" 条件上等待
            }

            queue.add(value);
            System.out.println("生产者 " + Thread.currentThread().getName() + " 生产了: " + value);

            // 3. 精确唤醒: 只唤醒一个在 "notEmpty" 上等待的消费者
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            // 2. 检查队列是否为空
            while (queue.isEmpty()) {
                System.out.println("队列为空, 消费者 " + Thread.currentThread().getName() + " 等待中...");
                notEmpty.await(); // 在 "notEmpty" 条件上等待
            }

            int value = queue.poll();
            System.out.println("消费者 " + Thread.currentThread().getName() + " 消费了: " + value);

            // 3. 精确唤醒: 只唤醒一个在 "notFull" 上等待的生产者
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}