public class deadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(()->{
            synchronized (o1){
                System.out.println("Thread1 get o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2){
                    System.out.println("Thread1 get o2");
                }
            }
        },"thread1");
        Thread thread2 = new Thread(()->{
            synchronized (o2){
                System.out.println("Thread2 get o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o1){
                    System.out.println("Thread2 get o1");
                }
            }
        },"thread2");
        thread1.start();
        thread2.start();

    }
}
