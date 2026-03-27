public class num2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length,n=mat[0].length;
        int[][] tmp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tmp[i][j]=mat[i][j];
            }
        }
        for(int i=0;i<k;i++){
            tmp=rotation(tmp);
        }
        System.out.println();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if (mat[i][j] != tmp[i][j]) return false;
            }
        }
        return true;
    }
    public int[][] rotation(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i%2==0)tmp[i][j] = grid[i][(j+1)% n];
                else tmp[i][j] = grid[i][(j-1+n)% n];
            }
        }
        return tmp;
    }
}
