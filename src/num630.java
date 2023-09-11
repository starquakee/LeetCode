import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class num630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        Queue<int[]> queue = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int days = 0;
        for(int[] course:courses){
            days+=course[0];
            queue.offer(course);
            if(days>course[1]){
                days -= queue.poll()[0];
            }
        }
        return queue.size();
    }
}
