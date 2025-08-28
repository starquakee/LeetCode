import java.util.ArrayList;
import java.util.List;

public class num3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int[][] ans = new int[n][n];
        for(int i=n-1;i>=0;i--){
            List<Integer> list = new ArrayList<>();
            int x=i,y=0;
            while (x<n&&y<n){
                list.add(grid[x][y]);
                x++;
                y++;
            }
            list.sort((a,b)->a-b);
            x=i;y=0;
            while (x<n&&y<n){
                ans[x][y]=list.remove(list.size()-1);
                x++;
                y++;
            }
        }
        for(int i=1;i<n;i++){
            List<Integer> list = new ArrayList<>();
            int x=0,y=i;
            while (x<n&&y<n){
                list.add(grid[x][y]);
                x++;
                y++;
            }
            list.sort((a,b)->b-a);
            x=0;y=i;
            while (x<n&&y<n){
                ans[x][y]=list.remove(list.size()-1);
                x++;
                y++;
            }
        }
        return ans;
    }
}
