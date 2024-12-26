public class num688 {
    static int[][] dirs = new int[][]{{-2,1},{-2,-1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}};
//    Recursive O(8^k)
//    public double knightProbability(int n, int k, int row, int column) {
//        if(row>=n||column>=n||column<0||row<0)return 0;
//        if(k==0)return 1;
//        double ans = 0;
//        for(int i=0;i<8;i++){
//            ans += knightProbability(n,k-1,row+dir[i][0],column+dir[i][1])/8;
//        }
//        return ans;
//    }

//  DP O(k*n^2)
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(int z=0;z<=k;z++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(z==0){
                        dp[z][i][j]=1;
                    }else {
                        for(int[] dir:dirs){
                            int newi=i+dir[0];
                            int newj=j+dir[1];
                            if(newi>=0&&newi<n&&newj>=0&&newj<n){
                                dp[z][i][j] += dp[z-1][newi][newj]/8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
