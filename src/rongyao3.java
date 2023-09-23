import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rongyao3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean J1=false;
        boolean J2=false;
        int[] arr = new int[15];
        int ans = 0;
        for(int i=0;i<n;i++){
            String s = input.next();
            if(s.equals("J1")){
                J1=true;
            } else if (s.equals("J2")) {
                J2=true;
            }else {
                String ss = s.substring(1);
                if(ss.equals("J")){
                    arr[11]++;
                }else if(ss.equals("Q")){
                    arr[12]++;
                }else if(ss.equals("K")){
                    arr[13]++;
                }else if(ss.equals("A")){
                    arr[14]++;
                }else arr[Integer.parseInt(ss)]++;
            }
        }
        if(J1&&J2)ans+=5;
        for(int i=2;i<15;i++){
            if(arr[i]==4){
                ans += 5;
                arr[i] = 0;
            } else if (arr[i] == 3) {
                ans += 4;
                arr[i] = 0;
            }
        }
        int l=2;
        int r=2;
        while (r<15){
            if(r-l==4){
                for(int i=l;i<r;i++){
                    arr[i]--;
                }
                l=r;
                ans += 3;
            }
            if(arr[r]>0){
                r++;
            }else {
                l = r;
                r++;
            }
        }
        for(int i=2;i<15;i++){
            if(arr[i]==2){
                ans += 2;
                arr[i]=0;
            }
        }
        System.out.println(ans);
    }
}
