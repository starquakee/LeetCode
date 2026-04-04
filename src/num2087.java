import java.util.ArrayDeque;
import java.util.Arrays;

public class num2087 {
//    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
//        int m=rowCosts.length;
//        int n=colCosts.length;
//        int ans=0;
//        boolean[][] visited=new boolean[m][n];
//        int x=startPos[0],y=startPos[1];
//        int[][] cost=new int[m][n];
//        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
//        for(int i=0;i<m;i++){
//            Arrays.fill(cost[i],Integer.MAX_VALUE);
//        }
//        cost[x][y]=0;
//        ArrayDeque queue=new ArrayDeque<int[]>();
//        queue.offer(new int[]{x,y});
//        while (!queue.isEmpty()){
//            int[] cur=(int[]) queue.poll();
//            int curx=cur[0],cury=cur[1];
//    }
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int r1 = startPos[0], c1 = startPos[1];
        int r2 = homePos[0], c2 = homePos[1];
        int res = 0;
        if (r2 >= r1) {
            for (int i = r1 + 1; i <= r2; i++) {
                res += rowCosts[i];
            }
        } else {
            for (int i = r2; i < r1; i++) {
                res += rowCosts[i];
            }
        }
        if (c2 >= c1) {
            for (int i = c1 + 1; i <= c2; i++) {
                res += colCosts[i];
            }
        } else {
            for (int i = c2; i < c1; i++) {
                res += colCosts[i];
            }
        }
        return res;
    }
}
