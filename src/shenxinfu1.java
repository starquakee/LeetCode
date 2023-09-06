import java.util.Random;
import java.util.Scanner;

public class shenxinfu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //String input = in.next();
        Random random = new Random();
        if(random.nextInt(2)==0){
            System.out.print("true");
        } else System.out.print("false");
    }
}
