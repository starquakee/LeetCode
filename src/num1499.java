import java.util.PriorityQueue;

public class num1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int ans= Integer.MIN_VALUE;
        for(int[] point:points){
            int x = point[0];
            int y = point[1];
            while (!priorityQueue.isEmpty()&&x-priorityQueue.peek()[1]>k){
                priorityQueue.poll();
            }
            if(!priorityQueue.isEmpty()){
                ans = Math.max(ans, x+y+priorityQueue.peek()[0]);
            }
            priorityQueue.offer(new int[]{y-x,x});
        }
        return ans;
    }
}
