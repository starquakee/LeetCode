public class num799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[101][101];
        dp[0][0] = poured;
        for(int i=1;i<=100;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=Math.max(0,(dp[i-1][j]-1)/2);
                }else {
                    dp[i][j]=Math.max(0,(dp[i-1][j]-1)/2)+Math.max(0,(dp[i-1][j-1]-1)/2);
                }
            }
        }
        return Math.min(dp[query_row][query_glass],1);
    }
}
