public class num1351 {
    public int countNegatives(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        int index=n;
        for(int i=0;i<m;i++){
            while (index>0&&grid[i][index-1]<0)index--;
            ans+=n-index;
        }
        return ans;
    }
}
