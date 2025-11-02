public class num2257 {
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grids=new int[m][n];
        int ans=0;
        for(int[] wall:walls){
            grids[wall[0]][wall[1]]=-1;
        }
        for(int[] guard:guards){
            grids[guard[0]][guard[1]]=-1;
        }
        for(int[] guard:guards){
            int x=guard[0];
            int y=guard[1];
            for(int i=0;i<4;i++){
                int newX=x+dirs[i][0];
                int newY=y+dirs[i][1];
                while (newX>=0&&newX<m&&newY>=0&&newY<n){
                    if(grids[newX][newY]==-1)break;
                    grids[newX][newY]=1;
                    newX+=dirs[i][0];
                    newY+=dirs[i][1];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grids[i][j]==0)ans++;
            }
        }
        return ans;
    }
}
