import java.util.Arrays;

public class num931 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }else{
                    int min = Math.min(dp[i-1][j],dp[i-1][j+1]);
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j-1],min);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            min = Math.min(min,dp[matrix.length-1][j]);
        }
        System.out.println(Arrays.deepToString(dp));
        return min;
    }
}
