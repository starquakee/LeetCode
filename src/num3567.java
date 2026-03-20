import java.util.Arrays;

public class num3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][] ans=new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++) {
                int[] temp=new int[k*k];
                int index=0;
                for(int p=i;p<i+k;p++) {
                    for (int q = j; q < j + k; q++) {
                        temp[index++] = grid[p][q];
                    }
                }
                Arrays.sort(temp);
                int minDiff=Integer.MAX_VALUE;
                for(int p=1;p<temp.length;p++){
                    minDiff=Math.min(minDiff, temp[p]-temp[p-1]==0?Integer.MAX_VALUE:temp[p]-temp[p-1]);
                }
                ans[i][j]=minDiff==Integer.MAX_VALUE?0:minDiff;
            }
        }
        return ans;
    }
}
