public class num3963 {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        grid[0]="";
        for(int i=0;i<n;i++)grid[0]+=".";
        for (int i = 1; i < m; i++) {
            grid[i]="";
            for(int j = 0; j <n-1; j++)grid[i]+="#";
            grid[i] += ".";
        }
        return grid;
    }
}
