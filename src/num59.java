public class num59 {
//    public int[][] generateMatrix(int n) {
//        int[][] ans = new int[n][n];
//        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int num=1;
//        int i=0,j=0;
//        ans[0][0]=1;
//        int d=0;
//        for(int z=1;z<n*n;z++){
//            int newi=i+dirs[d%4][0];
//            int newj=j+dirs[d%4][1];
//            if(newi<n&&newi>=0&&newj<n&&newj>=0){
//                if (ans[newi][newj] != 0) {
//                    d++;
//                    newi = i + dirs[d % 4][0];
//                    newj = j + dirs[d % 4][1];
//                }
//            }else {
//                d++;
//                newi=i+dirs[d%4][0];
//                newj=j+dirs[d%4][1];
//            }
//            ans[newi][newj]=++num;
//            i=newi;
//            j=newj;
//        }
//        return ans;
//    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x=0;
        int y=0;
        int count=0;
        for(int i=1;i<=n*n;i++){
            ans[x][y]=i;
            int newx=x+dirs[count%4][0];
            int newy=y+dirs[count%4][1];
            if(newx>=0&&newx<n&&newy>=0&&newy<n&&ans[newx][newy]==0){
                x=newx;
                y=newy;
            }else {
                count++;
                x+=dirs[count%4][0];
                y+=dirs[count%4][1];
            }
        }
        return ans;
    }
}
