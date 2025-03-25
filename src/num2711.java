import java.util.HashMap;
import java.util.Map;

public class num2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int[][] ans=new int[m][n];
        for(int i=n-1;i>=0;i--){
            int x=0;
            int y=i;
            Map<Integer,Integer> topLeft= new HashMap<>();
            Map<Integer,Integer> bottomRight= new HashMap<>();
            boolean isFirst=true;
            while (x<m&&y<n){
                if(isFirst){
                    int xDown=x+1;
                    int yDown=y+1;
                    while (xDown<m&&yDown<n){
                        bottomRight.put(grid[xDown][yDown],bottomRight.getOrDefault(grid[xDown][yDown],0)+1);
                        xDown++;
                        yDown++;
                    }
                    ans[x][y]=Math.abs(bottomRight.size());
                    x++;
                    y++;
                    isFirst=false;
                }else {
                    topLeft.put(grid[x-1][y-1],topLeft.getOrDefault(grid[x-1][y-1],0)+1);
                    int num=bottomRight.get(grid[x][y])-1;
                    if(num==0){
                        bottomRight.remove(grid[x][y]);
                    }else bottomRight.put(grid[x][y],num);
                    ans[x][y]=Math.abs(topLeft.size()-bottomRight.size());
                    x++;
                    y++;
                }
            }
        }

        for(int j=m-1;j>0;j--){
            int x=j;
            int y=0;
            Map<Integer,Integer> topLeft= new HashMap<>();
            Map<Integer,Integer> bottomRight= new HashMap<>();
            boolean isFirst=true;
            while (x<m&&y<n){
                if(isFirst){
                    int xDown=x+1;
                    int yDown=y+1;
                    while (xDown<m&&yDown<n){
                        bottomRight.put(grid[xDown][yDown],bottomRight.getOrDefault(grid[xDown][yDown],0)+1);
                        xDown++;
                        yDown++;
                    }
                    ans[x][y]=Math.abs(bottomRight.size());
                    x++;
                    y++;
                    isFirst=false;
                }else {
                    topLeft.put(grid[x-1][y-1],topLeft.getOrDefault(grid[x-1][y-1],0)+1);
                    int num=bottomRight.get(grid[x][y])-1;
                    if(num==0){
                        bottomRight.remove(grid[x][y]);
                    }else bottomRight.put(grid[x][y],num);
                    ans[x][y]=Math.abs(topLeft.size()-bottomRight.size());
                    x++;
                    y++;
                }
            }
        }
        return ans;
    }
}
