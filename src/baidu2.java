import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baidu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        boolean[] brr = new boolean[k+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int j = 0;j<n;j++){
            arr[j] = in.nextInt();
            map.put(arr[j],j);
        }
        int l = 0;
        int r = k-1;
        int lose = k;
        for(int i=0;i<k;i++){
            if(arr[i]<=k&&brr[arr[i]]==false){
                brr[arr[i]] = true;
                lose--;
            }

        }
        while (r<n){
            if(lose==0){
                System.out.println("YES");
                System.out.println("0");
                break;
            }
            if(lose==1){
                int need = 0;
                for(int i=1;i<=k;i++){

                    if(brr[i]==false){
                        need = i;
                    }
                }
                for(int i=l;i<=r;i++){
                    if(arr[i]>k){
                        System.out.println("YES");
                        System.out.println("1");
                        System.out.println(need+" "+arr[i]);
                        break;
                    }
                }
            }
            if(arr[l]<=k){
                brr[arr[l]] = false;
            }
            if(arr[l]<=k) lose++;
            if(r+1<n&&arr[r+1]<=k){
                brr[arr[r+1]] = true;
                if(arr[r+1]<=k) lose--;
            }
            l++;
            r++;
        }
    }
}
