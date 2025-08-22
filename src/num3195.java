public class num3195 {
    public int minimumArea(int[][] grid) {
        int minX=-1,maxX = -1,minY=-1,maxY=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minX=i;
                    break;
                }
            }
            if(minX!=-1) break;
        }
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j]==1){
                    maxX=i;
                    break;
                }
            }
            if(maxX!=-1) break;
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    minY=i;
                    break;
                }
            }
            if(minY!=-1) break;
        }
        for(int i=grid[0].length-1;i>=0;i--){
            for(int j=grid.length-1;j>=0;j--){
                if(grid[j][i]==1){
                    maxY=i;
                    break;
                }
            }
            if(maxY!=-1) break;
        }
        return (maxX-minX+1)*(maxY-minY+1);
    }
}
