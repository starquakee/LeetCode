import java.util.HashMap;
import java.util.Map;

public class num1267 {
    public int countServers(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer,Integer> columns = new HashMap<>();
        Map<Integer,Integer> rows = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans++;
                    rows.put(i,rows.getOrDefault(i,0)+1);
                    columns.put(j,columns.getOrDefault(j,0)+1);
                }
            }
        }
        for(int i=0;i<m;i++){
            if(rows.getOrDefault(i,0)==1){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        if(columns.get(j)==1){
                            ans--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
