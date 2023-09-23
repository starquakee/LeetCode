import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class rongyao1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(input.nextInt());
        }
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
            b[i] = input.nextInt();
        }
        for(int i=0;i<n;i++){
            if(a[i]!=b[i]&&a[i]<=list.size()){
                list.remove(a[i]-1);
            } else if (b[i] > list.size()&&a[i]<=list.size()) {
                list.remove(a[i]-1);
            }
            if(list.size()<=1){
                System.out.println("Fail!"+" "+list.get(0));
            }
        }
        if(list.size()>1){
            Collections.sort(list);
            System.out.print("Success!");
            for(int i=0;i<list.size();i++){
                System.out.print(" "+list.get(i));
            }
        }
    }
}
