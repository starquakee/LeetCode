import java.util.*;

public class num1619_bfs {
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    list.add(bfs(land, i, j));
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    public int bfs(int[][] land, int x, int y) {
        int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int m = land.length;
        int n = land[0].length;
        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        land[x][y]=-1;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x_cur = temp[0];
            int y_cur = temp[1];
            ans++;
            for(int i=0;i<8;i++){
                int x_new = x_cur+dire[i][0];
                int y_new = y_cur+dire[i][1];
                if(x_new>=0&&x_new<m&&y_new>=0&&y_new<n){
                    if(land[x_new][y_new]==0){
                        land[x_new][y_new]=-1;
                        queue.offer(new int[]{x_new,y_new});
                    }
                }
            }
        }
        return ans;
    }
}
