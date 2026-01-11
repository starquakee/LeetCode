import java.util.Arrays;

public class num85 {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] left=new int[m][n];
        for(int i=0;i<m;i++){
            left[i][0]=matrix[i][0]-'0';
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1')left[i][j]=left[i][j-1]+1;
                else left[i][j]=0;
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(left[i][j]>0){
                    int minWidth=Integer.MAX_VALUE;
                    for(int k=i;k>=0;k--){
                        if(left[k][j]==0)break;
                        minWidth=Math.min(minWidth,left[k][j]);
                        ans=Math.max(ans,minWidth*(i-k+1));
                    }
                }
            }
        }
        return ans;
    }
}
