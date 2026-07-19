import java.util.List;

public class num1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        int n = list.size();
        k = k % n;
        List<List<Integer>> ans = new java.util.ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new java.util.ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(list.get((i * grid[0].length + j - k + n) % n));
            }
            ans.add(row);
        }
        return ans;
    }
}
