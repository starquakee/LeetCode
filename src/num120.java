import java.util.Arrays;
import java.util.List;

public class num120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int self=triangle.get(i).get(j);
                if(j==0)dp[i][j]=dp[i-1][j]+self;
                else if(j==i)dp[i][j]=dp[i-1][j-1]+self;
                else dp[i][j]=self+Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}
