import java.util.*;

public class xiaomi22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        String[] strings = s.split(",");
        List<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        int[] in = new int[n];
        for (String string : strings) {
            int a = Integer.parseInt(string.split(":")[0]);
            int b = Integer.parseInt(string.split(":")[1]);
            g[b].add(a);
            in[a]++;
        }
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int num =queue.poll();
            cnt++;
            for(int child:g[num]){
                in[child]--;
                if(in[child]==0){
                    queue.offer(child);
                }
            }
        }
        if(cnt==n){
            System.out.println(1);
        } else System.out.println(0);
    }
}
