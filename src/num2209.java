import java.util.Arrays;

public class num2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[][] dp = new int[n][numCarpets+1];
        dp[0][0]=floor.charAt(0)-'0';
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+floor.charAt(i)-'0';
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<=numCarpets;j++){
                if(i-carpetLen<0){
                    dp[i][j]=0;
                }else dp[i][j]=Math.min(dp[Math.max(0,i-1)][j]+floor.charAt(i)-'0',dp[Math.max(0,i-carpetLen)][j-1]);
            }
        }
        return dp[n-1][numCarpets];
    }
}
