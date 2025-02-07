public class num59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int num=1;
        int i=0,j=0;
        ans[0][0]=1;
        int d=0;
        for(int z=1;z<n*n;z++){
            int newi=i+dirs[d%4][0];
            int newj=j+dirs[d%4][1];
            if(newi<n&&newi>=0&&newj<n&&newj>=0){
                if (ans[newi][newj] != 0) {
                    d++;
                    newi = i + dirs[d % 4][0];
                    newj = j + dirs[d % 4][1];
                }
            }else {
                d++;
                newi=i+dirs[d%4][0];
                newj=j+dirs[d%4][1];
            }
            ans[newi][newj]=++num;
            i=newi;
            j=newj;
        }
        return ans;
    }
}
