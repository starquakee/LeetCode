import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class huawei21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int offset = 0;
        Map<Integer,Integer> start = new HashMap<>();
        Map<Integer,Integer> end = new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
            if(!start.containsKey(arr[i])){
                start.put(arr[i],i);
                end.put(arr[i],i);
            }else {
                end.put(arr[i],i);
            }
            if(i>0&&arr[i]<arr[i-1]){
                offset = i;
            }
        }
        int num = input.nextInt();
        if(offset==0){
            System.out.println(start.getOrDefault(num,-1)+" "+end.getOrDefault(num,-1));
        }else if(start.getOrDefault(num,-1)!=0||end.getOrDefault(num,-1)!=n-1){
            System.out.println(start.getOrDefault(num,-1)+" "+end.getOrDefault(num,-1));
        }else {
            System.out.print(n-1+" ");
            int r = -1;
            while (true){
                r++;
                if(arr[r]!=arr[n-1]){
                    break;
                }
            }
            System.out.println(r-1);
        }
    }
}
