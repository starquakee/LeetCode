import java.util.HashMap;
import java.util.Map;

public class num2596 {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        Map<Integer,Integer> x = new HashMap<>();
        Map<Integer,Integer> y = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                x.put(grid[i][j],i);
                y.put(grid[i][j],j);
            }
        }
        int preX=0;
        int preY=0;
        for(int i=1;i<grid.length*grid.length;i++){
            if(x.get(i)>=0&&x.get(i)<grid.length&&y.get(i)>=0&&y.get(i)<grid.length){
                if((Math.abs(x.get(i)-preX)==2&&Math.abs(y.get(i)-preY)==1)||(Math.abs(x.get(i)-preX)==1&&Math.abs(y.get(i)-preY)==2)){
                    preX = x.get(i);
                    preY = y.get(i);
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
