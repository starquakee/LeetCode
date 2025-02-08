public class num63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0&&obstacleGrid[0][0]==0) dp[0][0]=1;
                if(obstacleGrid[i][j]==1)continue;
                int leftX=i;
                int leftY=j-1;
                if(leftY>=0&&obstacleGrid[leftX][leftY]==0){
                    dp[i][j]+=dp[leftX][leftY];
                }
                int upX=i-1;
                int upY=j;
                if(upX>=0&&obstacleGrid[upX][upY]==0){
                    dp[i][j]+=dp[upX][upY];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
