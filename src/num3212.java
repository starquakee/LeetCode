public class num3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int ans=0;
        int[][] sumX = new int[m+1][n+1];
        int[][] sumY = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    sumX[i][j]=grid[i][j]=='X'?1:0;
                    sumY[i][j]=grid[i][j]=='Y'?1:0;
                }
                if(i==0){
                    sumX[i][j]=grid[i][j]=='X'?1:0;
                    sumY[i][j]=grid[i][j]=='Y'?1:0;
                } else {
                    sumX[i][j]=sumX[i-1][j]+(grid[i][j]=='X'?1:0);
                    sumY[i][j]=sumY[i-1][j]+(grid[i][j]=='Y'?1:0);
                }
            }
        }
        for(int i=0;i<m;i++){
            int countX=0;
            int countY=0;
            for(int j=0;j<n;j++){
                countX+=sumX[i][j];
                countY+=sumY[i][j];
                if(countX==countY&&countX>0)ans++;
            }
        }
        return ans;
    }
}
