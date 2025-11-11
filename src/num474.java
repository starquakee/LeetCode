public class num474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] a=new int[strs.length];
        int[] b=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int num1=0;
            int num2=0;
            for(char c:s.toCharArray()){
                if(c=='0')num1++;
                if(c=='1')num2++;
            }
            a[i]=num1;
            b[i]=num2;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<= strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    if(j-a[i-1]>=0&&k-b[i-1]>=0){
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-a[i-1]][k-b[i-1]]+1);
                    }else {
                        dp[i][j][k]=dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
