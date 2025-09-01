import java.util.PriorityQueue;

public class num1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            double a1 = (double) (a[0]+1)/(a[1]+1)-(double) a[0]/a[1];
            double b1 = (double) (b[0]+1)/(b[1]+1)-(double) b[0]/b[1];
            return Double.compare(b1,a1);
        });
        for(int[] cla:classes){
            pq.offer(cla);
        }
        while (extraStudents>0){
            int[] cla = pq.poll();
            cla[0]++;
            cla[1]++;
            pq.offer(cla);
            extraStudents--;
        }
        double ans=0;
        for(int[] cla:classes){
            ans+= (double) cla[0] /cla[1];
        }
        return ans/classes.length;
    }
}
