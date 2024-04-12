public class num2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for(int j=0;j<n;j++){
            boolean isChampion = true;
            for(int i=0;i<n;i++){
                if(grid[i][j]==1){
                    isChampion = false;
                    break;
                }
            }
            if(isChampion)return j;
        }
        return -1;
    }
}
