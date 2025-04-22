public class PrintOddEven {
    private static final Object lock = new Object();
    private static volatile int num=0;
    private static final int count=10;

    public static void main(String[] args) {
        Thread a = new Thread(()->{
            for(int i=0;i<count;i++){
                synchronized (lock){
                    while (num%2!=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Thread A print:"+num);
                    num++;
                    lock.notifyAll();
                }
            }
        });
        Thread b = new Thread(()->{
            for(int i=0;i<count;i++){
                synchronized (lock){
                    while (num%2!=1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Thread B print:"+num);
                    num++;
                    lock.notifyAll();
                }
            }
        });
        a.start();
        b.start();
    }
}
