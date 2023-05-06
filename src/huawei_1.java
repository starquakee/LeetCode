import java.util.Map;
import java.util.Scanner;

public class huawei_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        String a = s.split("\\+")[0];
        String b = s.split("\\+")[1];
        float a_float = Float.parseFloat(a);
        float b_float = Float.parseFloat(b);
        int len_a = a.length();
        int len_b = b.length();
        int mul=0;
        if(a.contains(".")){
            mul = a.split("\\.")[1].length();
        }
        if(b.contains(".")){
            mul = Math.max(mul, b.split("\\.")[1].length());
        }
        a_float *= Math.pow(10,mul);
        b_float *= Math.pow(10,mul);
        System.out.println(a_float+" "+b_float);
        int len = Math.max(a.split("\\.")[0].length(),b.split("\\.")[0].length())+mul+1;
        int[] array_a = new int[len];
        int[] array_b = new int[len];

    }
}
