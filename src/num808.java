public class num808 {
    public double soupServings(int n) {
        if(n==0)return 0.5;
        if(n>=5000)return 1;
        int rest1=(n-1)/25+1;
        int rest2=(n-1)/25+1;
        double[][] dp=new double[rest1+1][rest2+1];
        dp[0][0]=0.5;
        for(int i=1;i<dp.length;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=0.25*(dp[Math.max(0,i-4)][j]+dp[Math.max(0,i-3)][Math.max(0,j-1)]
                        +dp[Math.max(0,i-2)][Math.max(0,j-2)]+dp[Math.max(0,i-1)][Math.max(0,j-3)]);
            }
        }
        return dp[rest1][rest2];
    }
}
