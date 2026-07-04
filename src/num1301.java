import java.util.List;

public class num1301 {
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        long[][][] dp = new long[n][n][2];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(board.get(i).charAt(j)=='X') continue;
                if(i==n-1 && j==n-1){
                    dp[i][j][0]=0;
                    dp[i][j][1]=1;
                }else{
                    long max=-1;
                    long count=0;
                    if(i+1<n && dp[i+1][j][1]>0){
                        max=Math.max(max,dp[i+1][j][0]);
                    }
                    if(j+1<n && dp[i][j+1][1]>0){
                        max=Math.max(max,dp[i][j+1][0]);
                    }
                    if(i+1<n && j+1<n && dp[i+1][j+1][1]>0){
                        max=Math.max(max,dp[i+1][j+1][0]);
                    }
                    if(max==-1) continue;
                    if(i+1<n && dp[i+1][j][0]==max){
                        count+=dp[i+1][j][1];
                    }
                    if(j+1<n && dp[i][j+1][0]==max){
                        count+=dp[i][j+1][1];
                    }
                    if(i+1<n && j+1<n && dp[i+1][j+1][0]==max){
                        count+=dp[i+1][j+1][1];
                    }
                    dp[i][j][0]=max+(board.get(i).charAt(j)-'0');
                    dp[i][j][1]=count%1000000007;
                }
            }
        }
        if(dp[0][0][1]==0) return new int[]{0,0};
        return new int[]{(int)dp[0][0][0]-21,(int)dp[0][0][1]};
    }
}
