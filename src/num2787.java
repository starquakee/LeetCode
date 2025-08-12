import java.util.Arrays;

public class num2787 {
    public int numberOfWays(int n, int x) {
        int mod=1000000007;
        //i为当前取得最大数，j为所有数字n次幂之和
        int[][] dp=new int[n+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(j>=(int)Math.pow(i,x)){
                    dp[i][j]=dp[i-1][j]+dp[i-1][(int) (j-Math.pow(i,x))];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
                dp[i][j]%=mod;
            }
        }
        return dp[n][n];
    }
}
