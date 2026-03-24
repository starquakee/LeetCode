public class num3546 {
    public boolean canPartitionGrid(int[][] grid) {
        long sum=0;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        if(sum%2!=0) return false;
        long target=sum/2;
        int m=grid.length,n=grid[0].length;
        sum=0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                sum+=grid[i][j];
            }
            if(sum==target) return true;
            if(sum>target) break;
        }
        sum=0;
        for(int j=0;j<n;j++) {
            for (int i = 0; i < m; i++) {
                sum+=grid[i][j];
            }
            if(sum==target) return true;
            if(sum>target) break;
         }
        return false;
    }
}
