import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class rongyao25_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input = in.nextLine();
        String[] arr=input.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String s:arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int minCount=Integer.MAX_VALUE;
        for(String s: map.keySet()){
            minCount=Math.min(minCount,map.get(s));
        }
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])!=minCount){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
