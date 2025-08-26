import java.util.PriorityQueue;

public class num3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)->{
            double a1 = Math.sqrt(a[0]*a[0]+a[1]*a[1]);
            double b1 = Math.sqrt(b[0]*b[0]+b[1]*b[1]);
            if(a1<b1)return 1;
            else if(a1>b1)return -1;
            else return b[0]*b[1]-a[0]*a[1];
        });
        for(int[] dim:dimensions){
            priorityQueue.offer(dim);
        }
        return priorityQueue.peek()[0]*priorityQueue.peek()[1];
    }
}
