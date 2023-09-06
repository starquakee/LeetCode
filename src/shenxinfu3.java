import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shenxinfu3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();;
        for(int i=0;i<num;i++){
            int n=input.nextInt();
            int[][] arr = new int[n][2];
            Map<Integer,String> map = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j][0] = input.nextInt();
                arr[j][1] = input.nextInt();
                map.put(arr[j][1],arr[j][0]+"&"+j);
            }
            int[] ans = new int[n];
            ans[0] = Integer.parseInt(map.get(0).split("&")[0]);
            int next = Integer.parseInt(map.get(0).split("&")[1])+1;
            int place=1;
            while (place<n){
                ans[place] = Integer.parseInt(map.get(next).split("&")[0]);
                next = Integer.parseInt(map.get(next).split("&")[1])+1;
                place++;
            }
            for(int j=0;j<n;j++){
                System.out.print(ans[j]+" ");
            }
            System.out.println();
        }
    }
}
