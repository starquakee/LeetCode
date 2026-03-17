public class num3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int ans=0;
        int[][] preSum = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0)preSum[i][j]=grid[i][j];
                if(i==0){
                    preSum[i][j]=grid[i][j];
                } else preSum[i][j]=preSum[i-1][j]+grid[i][j];
            }
        }
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=preSum[i][j];
                if(sum<=k)ans++;
                else break;
            }
        }
        return ans;
    }
}
