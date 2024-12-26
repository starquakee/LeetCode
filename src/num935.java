public class num935 {
    // DP O(n)
    public int knightDialer(int n) {
        long[][] dp = new long[n][10];
        int mod = 1000000007;
        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(i==0) dp[0][j]=1;else {
                    switch (j){
                        case 0:{
                            dp[i][j]=(dp[i-1][4]+dp[i-1][6]) % mod;
                            break;
                        }
                        case 1:{
                            dp[i][j]=(dp[i-1][6]+dp[i-1][8]) % mod;
                            break;
                        }
                        case 2:{
                            dp[i][j]=(dp[i-1][7]+dp[i-1][9]) % mod;
                            break;
                        }
                        case 3:{
                            dp[i][j]=(dp[i-1][4]+dp[i-1][8]) % mod;
                            break;
                        }
                        case 4:{
                            dp[i][j]=(dp[i-1][3]+dp[i-1][9]+dp[i-1][0]) % mod;
                            break;
                        }
                        case 5:{
                            dp[i][j]=0;
                            break;
                        }
                        case 6:{
                            dp[i][j]=(dp[i-1][1]+dp[i-1][7]+dp[i-1][0]) % mod;
                            break;
                        }
                        case 7:{
                            dp[i][j]=(dp[i-1][2]+dp[i-1][6]) % mod;
                            break;
                        }
                        case 8:{
                            dp[i][j]=(dp[i-1][1]+dp[i-1][3]) % mod;
                            break;
                        }
                        case 9:{
                            dp[i][j]=(dp[i-1][2]+dp[i-1][4]) % mod;
                            break;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<10;i++){
            ans = (int)((ans + dp[n-1][i]) % mod);
        }
        return ans;
    }
}
