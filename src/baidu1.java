import java.util.Scanner;

public class baidu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            if((n+m)%2==1){
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }
}
