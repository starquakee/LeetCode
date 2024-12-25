import java.util.Arrays;

public class num3218 {
    int[] horizontalCut;
    int[] verticalCut;
    int[][][][] mem;
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        this.mem=new int[m][m][n][n];
        this.horizontalCut = horizontalCut;
        this.verticalCut = verticalCut;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    Arrays.fill(this.mem[i][j][k],-1);
                }
            }
        }
        return dp(0,m-1,0,n-1);

    }
    public int dp(int row1,int row2,int col1,int col2){
        if(row1==row2&&col1==col2){
            mem[row1][row2][col1][col2]=0;
            return 0;
        }
        if(mem[row1][row2][col1][col2]!=-1)return mem[row1][row2][col1][col2];
        int ans = Integer.MAX_VALUE;
        for(int i=row1;i<row2;i++){
            ans = Math.min(ans, horizontalCut[i]+dp(row1,i,col1,col2)+dp(i+1,row2,col1,col2));
        }
        for(int i=col1;i<col2;i++){
            ans = Math.min(ans, verticalCut[i]+dp(row1,row2,col1,i)+dp(row1,row2,i+1,col2));
        }
        mem[row1][row2][col1][col2]=ans;
        return ans;
    }
}
