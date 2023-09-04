public class printABC {
    public static final Object object = new Object();
    public static volatile int number = 0;
    public static void main(String[] args) {
        Thread a = new Thread(()-> print("A",0));
        Thread b = new Thread(()-> print("B",1));
        Thread c = new Thread(()-> print("C",2));
        a.start();
        b.start();
        c.start();
    }
    public static void print(String mes,int num){
        for(int i=0;i<10;i++){
            synchronized (object){
                while (num!=number){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(mes);
                number = (number+1)%3;
                object.notifyAll();
            }
        }
    }
}
